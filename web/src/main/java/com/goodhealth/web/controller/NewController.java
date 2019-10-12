/**
 * 
 */
package com.goodhealth.web.controller;

import com.goodhealth.web.entity.News;
import com.goodhealth.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.goodhealth.comm.util.DateUtils;
import com.goodhealth.comm.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月10日
 * @Description
 */

@Controller
@RequestMapping("news")
public class NewController {
	
	@Autowired
	private NewsService newService;
	
	@RequestMapping("/com/goodhealth/framework/entity/user/findAll")
	public ModelAndView findAllDrug() {
		ModelAndView model = new ModelAndView("Display/showNews");
		try {
			List<News> list = this.newService.findAll();
			model.addObject("newsList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/admin/queryAll/{index}")
	public ModelAndView findAllDrug(@PathVariable("index")Integer index) {
		ModelAndView model = new ModelAndView("Manger/news_manage");
		try {
			Page<News> p = this.newService.findByPage(index);
			model.addObject("newsList", p.getContent());
			model.addObject("max", p.getTotalPages());
			model.addObject("index", index+1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/com/goodhealth/framework/entity/user/activities")
	public ModelAndView activities() {
		ModelAndView model = new ModelAndView("Display/showNews");
		try {
			List<News> list = this.newService.findByLikeCondition("newTitle", "线下活动");
			model.addObject("newsList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/admin/intoAddView")
	public  String  intoAddView(){ return "Manger/news_add"; }

	@RequestMapping("/admin/add")
	public  ModelAndView  addNews(@Valid News  news,BindingResult result,HttpServletRequest request, HttpServletResponse response){
		// 获取校验错误信息
		ModelAndView mv = new ModelAndView("Manger/news_add");
		try {
			if (result.hasErrors()) {
				// 输出错误信息
				List<ObjectError> allErrors = result.getAllErrors();
				// 将错误信息传到页面
				mv.addObject("news", news);
				mv.addObject("allErrors", allErrors);
				return mv;
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.YYYY_MM_DD_HH_MI_SS);
			news.setNewDate(simpleDateFormat.format(new Date()));
			this.newService.addNews(news);
			successAdd(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	public void successAdd(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('添加成功'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/news/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/admin/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response,String searchMess){
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtil.isNotNullString(searchMess)){
				List<News> list = newService.findByLikeCondition("newDetail",searchMess);
				if (!CollectionUtils.isEmpty(list)) {
					mv.addObject("newsList", list);
					mv.addObject("searchMess", searchMess);
					mv.setViewName("Manger/news_manage");
					return mv;
				}
			}
			searchFail(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("Manger/news_manage");
		return mv;
	}

	public void searchFail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('搜索无结果，请输入其他关键字'); </script>");
			out.print("<script> window.location.href='http://localhost:8080/news/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/admin/delete")
	public  String  deleteDrug(Integer  newsId,HttpServletRequest request, HttpServletResponse response){
		try {
			this.newService.deleteNewsById(newsId);
			successDelete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Manger/news_manage";
	}

	public void successDelete(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('删除成功'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/news/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

}
