package com.goodhealth.web.controller;

import com.goodhealth.web.entity.Member;
import com.goodhealth.web.entity.OrderItem;
import com.goodhealth.web.entity.Orders;
import com.goodhealth.web.entity.Shoppingcar;
import com.goodhealth.web.service.MemberService;
import com.goodhealth.web.service.OrderItemService;
import com.goodhealth.web.service.OrderService;
import com.goodhealth.web.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.comm.util.UUIDUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author 24663
 * @date 2019年1月4日
 * @Description
 */
@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private ShoppingCarService shoppingCarService;

	@RequestMapping("/admin/queryAll/{index}")
	public ModelAndView queryAll(@PathVariable("index")Integer index){
		ModelAndView mv = new ModelAndView("Manger/order");
		try{
			Page<Orders> p = orderService.findByPage(index);
			List<Orders> list = p.getContent();
			list.forEach(e->{
				String name = memberService.getMemberById(e.getMemberId()).getMemberName();
				e.setOrderContacts(name);
			});
			mv.addObject("orderList",list);
			mv.addObject("max",p.getTotalPages());
			mv.addObject("index",index+1);
		}catch (Exception e){
			e.printStackTrace();
		}
		return mv;
	}


	@RequestMapping("/generateOrderMany")
	public ModelAndView generateOrderMany(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("Display/showPayOrders");
		String[] carId = request.getParameterValues("intoOrder");
		Orders order = new Orders();
		order.setMemberId(((Member)request.getSession().getAttribute("member")).getMemberId());
        Date date = new Date();
     	SimpleDateFormat  sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     	String time = sdf.format(date);
     	String orderId= UUIDUtil.getUUID();
     	order.setOrderDate(time);
		try {
			int sum=0,prizeSum = 0;
			Shoppingcar record ;
			OrderItem item;
			StringBuffer  sBuffer = new StringBuffer();
			for (int i = 0; i < carId.length; i++) {
				record = shoppingCarService.getShoppingCarById(Integer.parseInt(carId[i]));
		     	item=new  OrderItem();
				item.setId(UUIDUtil.getUUID());
				item.setDrugId(record.getDrug().getDrugId());
				item.setNum(record.getRecordNumber());
				item.setOrderId(orderId);
				this.orderItemService.saveItem(item);
				sum+=(record.getRecordNumber())*(record.getDrug().getDrugPrice().intValue());
				prizeSum+=(record.getRecordNumber())*(record.getDrug().getDrugIntegral());
			    sBuffer.append( record.getDrug().getDrugName()+"*"+record.getRecordNumber());
			    sBuffer.append("\r\n");
				this.shoppingCarService.deleteShoppingCar(Integer.parseInt(carId[i]));
			}
			order.setOrderId(orderId);
			order.setOrderCount(new  BigDecimal(sum));
			order.setOrderAward(prizeSum );
			order.setOrderDetail(sBuffer.toString());
			order.setOrderStatus(0);
			this.orderService.addOrder(order);
			mv.addObject("order", order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/unpaid")
	public ModelAndView showUnpaidOrder(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("Display/unpaidOrder");
		HttpSession session=request.getSession(true);
		Member member=(Member) session.getAttribute("member");
		if (member == null) {
			needLoginFail(request, response);
		}
		try {
			List<Orders> list = this.orderService.findOnesUnpaidOrder(member);
			mv.addObject("orderList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/showOrder")
	public  String  showOnesOrder(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession(true);
		Member member=(Member) session.getAttribute("member");
		if (member == null) {
			needLoginFail(request, response);
		}
		try {
			List<Orders> list = this.orderService.findOnesOrder(member.getMemberId());
			model.addAttribute("orderList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showOrder";
	}

	@RequestMapping("/admin/showOnesOrder")
	public  String  showOnesOrder(Model model,Integer memberId,HttpServletRequest request,HttpServletResponse response){
		try {
			List<Orders> list = this.orderService.findOnesOrder(memberId);
			model.addAttribute("orderList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Manger/showOnesOrder";
	}
	

	
	@RequestMapping("/payOrder/{id}")
	public String payOrder(Model model, @PathVariable(value="id")String  id){
		Orders  orders;
			try {
				orders=this.orderService.findOrderById(id);
				model.addAttribute("order",orders);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "Display/showPayOrders";
	}

	@RequestMapping("/pay")
	public String pay(HttpServletRequest  request ,HttpServletResponse response,Model  model,
			String  orderId){
		Member  member=(Member) request.getSession(true).getAttribute("member");
		String  contacts=request.getParameter("username");
		String  tell=request.getParameter("tell");
		String  address=request.getParameter("province")+request.getParameter("city")+request.getParameter("area")+request.getParameter("address");
		try {
			SimpleDateFormat  sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String  time=sdf.format(new Date());
			Orders orders=this.orderService.findOrderById(orderId);
			//赠送奖励积分
			member.setMemberIntegral(member.getMemberIntegral()+orders.getOrderAward());
			this.memberService.addMember(member);
			//更新订单地址、联系人、联系电话、订单支付时间
			orders.setOrderAddress(contacts);
			orders.setOrderContacts(tell);
			orders.setOrderTell(address);
			orders.setOrderStatus(1);
			orders.setOrderDate(time);
			this.orderService.addOrder(orders);
			successPay(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showPayOrders";
	}

	@RequestMapping("/admin/search")
	public  ModelAndView  search(HttpServletRequest request, HttpServletResponse response,String  searchMess){
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtil.isNotNullString(searchMess)){
				List<Member> userList = memberService.findListByLikeName(searchMess);
				if (CollectionUtils.isEmpty(userList)){
					searchFail(request,response);
				}
				Page<Orders> p = orderService.findByMember(userList.get(0),0);
				List<Orders> list = p.getContent();
				if (!CollectionUtils.isEmpty(list)) {
					list.forEach(e->{
						e.setOrderContacts(userList.get(0).getMemberName());
					});
					mv.addObject("orderList", list);
					mv.addObject("searchMess", searchMess);
					mv.setViewName("Manger/order");
					return mv;
				}
			}
			searchFail(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("Manger/order");
		return mv;
	}

	public void searchFail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('搜索无结果，请输入其他关键字'); </script>");
			out.print("<script> window.location.href='http://localhost:8080/order/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	public void successPay(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('支付成功，可在个人中心-已完成订单中查询'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/shoppingcar/showMyShoppingCar'   </script>");
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	@RequestMapping("/admin/showCompletedOrder/{index}")
	public  String  showCompletedOrder(@PathVariable(value="index")int index,HttpServletRequest request, HttpServletResponse response,Model model){
		HttpSession session=request.getSession(true);
		Member member=(Member) session.getAttribute("member");
		try {
			Page<Orders> p = this.orderService.findOnesCompletedOrder(member, index);
			List<Orders> list = p.getContent();
			int maxPages = p.getTotalPages();
			model.addAttribute("completedOrderList", list);
			model.addAttribute("searchStatus", 2);
			model.addAttribute("max", maxPages);
			model.addAttribute("index", index + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Manger/MManger";
		
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

	public void success(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('操作成功'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/shoppingcar/showMyShoppingCar/'   </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
