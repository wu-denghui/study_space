/**
 * 
 */
package com.goodhealth.web.controller;

import com.goodhealth.web.entity.Member;
import com.goodhealth.web.entity.Shoppingcar;
import com.goodhealth.web.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月3日
 * @Description
 */
@Controller
@RequestMapping("shoppingcar")
public class ShoppingCarController {


	@Autowired
	private ShoppingCarService shoppingCarService;

	@RequestMapping("/showMyShoppingCar")
	public  String  showMyShoppingCar(HttpServletRequest request,HttpServletResponse response,Model model){
		HttpSession  session=request.getSession(true);
		Member member=(Member) session.getAttribute("member");
		if (member==null) {
			needLoginFail(request, response);
		}
		try {
			List<Shoppingcar> recordList=this.shoppingCarService.getOnesShoppingCarList(member);
            model.addAttribute("size",recordList.size());
            model.addAttribute("recordList",recordList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showShoppingCar";
	}

	public void needLoginFail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('请先登录'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/goodhealth/login'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/countAdd/{id}")
	public String  countAdd(@PathVariable("id")int id,HttpServletRequest request,HttpServletResponse response){
		  try {
			Shoppingcar  record=this.shoppingCarService.getShoppingCarById(id);
			int  old=record.getRecordNumber();
			record.setRecordNumber(old+1);
			this.shoppingCarService.addRecord(record);
			success(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showShoppingCar";
	}
	@RequestMapping("/countReduce/{id}")
	public String  countReduce(@PathVariable("id")int id,HttpServletRequest request,HttpServletResponse response){
		  try {
			Shoppingcar  record=this.shoppingCarService.getShoppingCarById(id);
			int  old=record.getRecordNumber();
			if (old==1) {
	            this.shoppingCarService.deleteShoppingCar(id);
	            success(request, response);
			}else{
			record.setRecordNumber(old-1);
			this.shoppingCarService.addRecord(record);
			success(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showShoppingCar";
	}
	
	@RequestMapping("/countDelete/{id}")
	public String  countDelete(@PathVariable("id")int id,HttpServletRequest request,HttpServletResponse response){
		  try {
            this.shoppingCarService.deleteShoppingCar(id);
			success(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showShoppingCar";
	}

	public void success(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> window.location.href=' http://localhost:8080/shoppingcar/showMyShoppingCar'   </script>");
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
