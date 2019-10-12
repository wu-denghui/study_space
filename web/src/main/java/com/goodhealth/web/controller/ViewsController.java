/**
 * 
 */
package com.goodhealth.web.controller;

import com.goodhealth.comm.util.token.SpringPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.goodhealth.comm.util.redis.RedisService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 24663
 * @date 2019年1月1日
 * @Description
 */
@RestController
@RequestMapping("/view")
public class ViewsController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping("admin/login")
	public String manger(){return "Manger/login"; }
	
	@GetMapping("/login")
	public Map<String,String> login(){
		Map<String,String> map = new HashMap<>();
//		map.put("data",redisService.get("bo"));
		map.put("config",SpringPropertiesUtil.getProperty("logging.path"));
		map.put("result","success");
		return map;
	}

	@RequestMapping("register")
	public  String  register(){
		return "Display/register";
	}

}
