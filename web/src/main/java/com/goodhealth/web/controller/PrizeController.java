/**
 * 
 */
package com.goodhealth.web.controller;

import com.goodhealth.web.entity.Member;
import com.goodhealth.web.entity.Orders;
import com.goodhealth.web.entity.Prize;
import com.goodhealth.web.service.MemberService;
import com.goodhealth.web.service.OrderService;
import com.goodhealth.web.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.goodhealth.comm.util.StringUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月7日
 * @Description
 */
@Controller
@RequestMapping("prize")
public class PrizeController {

	@Autowired
	private PrizeService prizeService;
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private MemberService memberService;

	@RequestMapping("/com/goodhealth/framework/entity/user/findAll")
	public ModelAndView showAllPrize() {
		ModelAndView model = new ModelAndView("Display/prizeHome");
		try {
			List<Prize> list = prizeService.findAll();
			model.addObject("prizeList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/admin/queryAll/{index}")
	public ModelAndView queryAll(@PathVariable("index")Integer index) {
		ModelAndView model = new ModelAndView("Manger/prize_manage");
		try {
			Page<Prize> p = prizeService.findByPage(index);
			model.addObject("prizeList", p.getContent());
			model.addObject("max", p.getTotalPages());
			model.addObject("index", index+1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping("/admin/intoAddView")
	public  String  intoAddView(){ return "Manger/prize_add"; }

	@RequestMapping("/showPrize")
	public ModelAndView showPrize(String orderId) {
		ModelAndView model = new ModelAndView("Display/showPrize");
		try {
			List<Prize> list = prizeService.findAll();
			model.addObject("prizeList", list);
			model.addObject("orderId",orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/exchange")
	public String exchange(HttpServletRequest request, HttpServletResponse response, 
		Integer prizeId, String orderId) {
		Member member = (Member) request.getSession(true).getAttribute("member");
		int old = member.getMemberIntegral();
		try {
			Prize prize = prizeService.findById(prizeId);
			if (old < prize.getPrizeValue()) {
				exchangeFail(request, response);
			} else {
				member.setMemberIntegral(old - prize.getPrizeValue());
				this.memberService.addMember(member);
				Orders orders=this.orderService.findOrderById(orderId);
				orders.setOrderAdditional(prize.getPrizeName());
				this.orderService.addOrder(orders);
				exchangeSuccess(request, response, orderId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showPrize";
	}



	public void exchangeSuccess(HttpServletRequest request, HttpServletResponse response, String id) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('兑换成功，积分商品将和您的订单一起送达'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/order/payOrder/" + id + "'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	public void exchangeFail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('积分不够'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/prize/showPrize'</script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
	
	@RequestMapping("/admin/add")
	public ModelAndView addPrize(@RequestParam("file") MultipartFile file,Prize  prize,HttpServletRequest request, HttpServletResponse response){
/*		if (file.isEmpty()){
			return "error";
		}
		if (file.getSize()>4*1025*128){
			return "error";
		}*/
		ModelAndView mv = new ModelAndView("Manger/prize_add");
		//图片名字
		String fileName = file.getOriginalFilename();
		//图片后缀
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		//文件存放路径
		String filePath = "E:\\eclipse\\goodhealth\\src\\main\\resources\\static\\images\\prize\\";
		//调用文件处理类FileUtil，处理文件，将文件写入指定位置
		// 获取校验错误信息
		try {
			file.transferTo(new File(filePath+fileName));
//			uploadFile(file.getBytes(), filePath, fileName);
			prize.setPrizePic(fileName);
			this.prizeService.addPrize(prize);
			successAddOrEdit(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	private void uploadFile(byte[] file, String filePath, String fileName) throws Exception{
		File targetFile = new File(filePath);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath+fileName);
		out.write(file);
		out.flush();
		out.close();
	}
	

	@RequestMapping("/admin/search")
	public  ModelAndView  search(HttpServletRequest request, HttpServletResponse response,String  searchMess){
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtil.isNotNullString(searchMess)){
				List<Prize> list = prizeService.findPrizeByNameLike(searchMess);
				if (!CollectionUtils.isEmpty(list)) {
					mv.addObject("prizeList", list);
					mv.addObject("searchMess", searchMess);
					mv.setViewName("Manger/prize_manage");
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
			out.print("<script> window.location.href='http://localhost:8080/prize/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/admin/edit")
	public  ModelAndView  edit(Integer prizeId){
		ModelAndView mv = new ModelAndView("Manger/prize_edit");
		try {
			Prize prize = prizeService.findById(prizeId);
			mv.addObject("prize", prize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/admin/save")
	public  ModelAndView  saveDrug(Prize prize, HttpServletRequest request, HttpServletResponse response){
		// 获取校验错误信息
		ModelAndView mv = new ModelAndView();
		try {
			prizeService.addPrize(prize);
			successAddOrEdit(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("Manger/prize_add");
		return mv;
	}

	@RequestMapping("/admin/delete")
	public  String  deletePrize(Integer prizeId, HttpServletRequest request, HttpServletResponse response){
		try {
			this.prizeService.deletePrizeById(prizeId);
			successDelete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Manger/prize";
	}

	public void successDelete(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('删除成功'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/prize/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	public void successAddOrEdit(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('操作成功'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/prize/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
