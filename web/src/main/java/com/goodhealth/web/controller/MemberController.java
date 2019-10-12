/**
 * 
 */
package com.goodhealth.web.controller;


import com.goodhealth.web.entity.Member;
import com.goodhealth.web.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.goodhealth.comm.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

/**
 * @author 24663
 * @date 2018年12月31日
 * @Description
 */
@Controller
@Slf4j
@RequestMapping("member")
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MemberService memberService;

	@RequestMapping("/admin/showMember/{index}")
	public  ModelAndView   showMember(@PathVariable(value = "index")Integer index, HttpServletRequest request){
		ModelAndView model = new ModelAndView("Manger/member_infos");
		try {
			Page<Member> p = memberService.findAllByPage(index);
			List<Member> list = p.getContent();
			list.forEach(e->{
				String address = "";
				if (StringUtil.isNotNullString(e.getProvince())){
					address += e.getProvince();
				}
				if (StringUtil.isNotNullString(e.getCity())){
					address += e.getCity();
				}
				if (StringUtil.isNotNullString(e.getArea())){
					address += e.getArea();
				}
				if (StringUtil.isNotNullString(e.getAddress())){
					address += e.getAddress();
				}
				e.setAddress(address);
			});
			int maxPages = p.getTotalPages();
			model.addObject("memberList", list);
			model.addObject("max", maxPages);
			model.addObject("index", index + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

    @RequestMapping("/admin/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response,String searchMess){
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtil.isNotNullString(searchMess)){
				List<Member> list = memberService.findListByLikeName(searchMess);
				if (!CollectionUtils.isEmpty(list)) {
					mv.addObject("memberList", list);
					mv.addObject("searchMess", searchMess);
					mv.setViewName("Manger/member_infos");
					return mv;
				}
			}
			searchFail(request,response);
		} catch (Exception e) {
			logger.info("查询药品失败",searchMess);
			e.printStackTrace();
		}
		mv.setViewName("Manger/member_infos");
		return mv;
	}
	
	public void searchFail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('搜索无结果，请输入其他关键字'); </script>");
			out.print("<script> window.location.href='http://localhost:8080/member/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/admin/intoModifyPasswordView")
	public  String  intoModifyPasswordView(){
		return "Manger/modify_password";
	}

	@RequestMapping("/admin/adminModifyPassword")
	public ModelAndView adminModifyPassword(HttpServletRequest request,String oldpassword, String password){
		ModelAndView mv = new ModelAndView("Manger/modify_password");
		HttpSession session = request.getSession();
		Member admin = (Member) session.getAttribute("member");
		if (Objects.nonNull(admin)&&oldpassword.equals(admin.getMemberPassword())){
			admin.setMemberPassword(password);
			memberService.addMember(admin);
			session.setAttribute("admin",admin);
			mv.setViewName("Manger/login");
			return mv;
		}
		mv.addObject("error","原始密码错误");
		return mv;
	}

}
