/**
 * 
 */
package com.goodhealth.web.controller;

import com.goodhealth.web.entity.Member;
import com.goodhealth.web.service.MemberService;
import com.goodhealth.web.entity.Drug;
import com.goodhealth.web.entity.Shoppingcar;
import com.goodhealth.web.service.DrugService;
import com.goodhealth.web.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.goodhealth.comm.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 24663
 * @date 2019年1月2日
 * @Description
 */
@Controller
@RequestMapping("drug")
public class DrugController {

	@Autowired
	private DrugService drugService;

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ShoppingCarService shoppingCarService;

	@RequestMapping("/com/goodhealth/framework/entity/user/findAll")
	public ModelAndView findAll() {
		ModelAndView model = new ModelAndView("Display/showDrug");
		try {
			List<Drug> list = this.drugService.findAll();
			model.addObject("drugList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/admin/queryAll/{index}")
	public ModelAndView queryByPage(@PathVariable(value = "index") int index) {
		ModelAndView model = new ModelAndView("Manger/drug_manage");
		try {
			Page<Drug> p = this.drugService.findByPage(index);
			List<Drug> list = p.getContent();
			int maxPages = p.getTotalPages();
			model.addObject("drugList", list);
			model.addObject("max", maxPages);
			model.addObject("index", index + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@GetMapping("/com/goodhealth/framework/entity/user/findByCondition")
	public ModelAndView findByCondition(@RequestParam("producer") String producer){
		ModelAndView model = new ModelAndView("Display/showDrug");
		try {
			List<Drug> list = this.drugService.findByProducer(producer);
			model.addObject("drugList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@GetMapping("/com/goodhealth/framework/entity/user/findByFunction")
	public ModelAndView findByFunction(@RequestParam("param") String param){
		ModelAndView model = new ModelAndView("Display/showDrug");
		try {
			List<Drug> list = this.drugService.findByCondition("drugFunction",param);
			model.addObject("drugList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/com/goodhealth/framework/entity/user/half")
	public ModelAndView findByCondition(){
		ModelAndView model = new ModelAndView("Display/halfPriceDrug");
		try {
			List<Drug> list = this.drugService.findHalfPriceDrug();
			model.addObject("drugList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping("/com/goodhealth/framework/entity/user/searchDrug")
	public  ModelAndView  search(HttpServletRequest request, HttpServletResponse response,String  searchMess,Model model){
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtil.isNotNullString(searchMess)){
				List<Drug> list=this.drugService.findDrugListByLikeName(searchMess);
				if (!list.isEmpty()) {
					model.addAttribute("drugList", list);
					mv.setViewName("Display/showDrug");
					return mv;
				}
					model.addAttribute("mess", searchMess);
					searchFail(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("Display/showDrug");
		return mv;
	}
	

	@RequestMapping("/com/goodhealth/framework/entity/user/showDetail")
	public String showDetail(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Drug drug = this.drugService.findById(id);
			model.addAttribute("drug", drug);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Display/showDetail";
	}

	@RequestMapping("/admin/details")
	public String details(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Drug drug = this.drugService.findById(id);
			model.addAttribute("drug", drug);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Manger/drug_details";
	}

	@RequestMapping("/intoShoppingCar")
	public String intoShoppingCar(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(true);
		Member member = (Member) session.getAttribute("member");
		if (member == null) {
			memberService.needLoginFail(request, response);
		} else {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Drug drug = drugService.findById(id);
				Shoppingcar record = shoppingCarService.isHas(member, drug);
				SimpleDateFormat  sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String  time=sdf.format(new Date());
				if (record==null) {
					//用户member之前未将药品drug放进购物车
					/*新建一条记录，将drug放进member的购物车*/
					Shoppingcar re = new Shoppingcar();
					re.setDrug(drug);
					re.setMember(member);
					re.setRecordNumber(1);
					re.setRecordDate(time);
					shoppingCarService.addRecord(re);
				}else{
				/*	将原来记录的药品购买数目+1*/
				     record.setRecordNumber(record.getRecordNumber()+1);
				 	 shoppingCarService.addRecord(record);
				}
				successToShoppingCar(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Display/showDrug";
	}

	@RequestMapping("/admin/save")
	public  ModelAndView  saveDrug(Drug drug, HttpServletRequest request, HttpServletResponse response){
		// 获取校验错误信息
		ModelAndView mv = new ModelAndView();
		try {
			this.drugService.addDrug(drug);
			successAddOrEdit(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("Manger/drug_add");
		return mv;
	}

	@RequestMapping("/admin/add")
	public  ModelAndView  addDrug(Drug drug, @RequestParam("file") MultipartFile file ,HttpServletRequest request, HttpServletResponse response){
		// 获取校验错误信息
		String fileName = file.getOriginalFilename();  //图片名字
		//文件存放路径
		String filePath = "E:\\eclipse\\goodhealth\\src\\main\\resources\\static\\images\\drug\\";
		//调用文件处理类FileUtil，处理文件，将文件写入指定位置
		try {
			uploadFile(file.getBytes(), filePath, fileName);
			drug.setDrugPic(fileName);
			this.drugService.addDrug(drug);
			successAddOrEdit(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Mange/drug_add");
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

	@RequestMapping("/admin/intoAddView")
	public  String  intoAddView(){ return "Manger/drug_add"; }


	@RequestMapping("/admin/search")
	public ModelAndView searchDrugForManger(HttpServletRequest request, HttpServletResponse response,String  searchMess){
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtil.isNotNullString(searchMess)){
				List<Drug>  list=this.drugService.findDrugListByLikeName(searchMess);
				if (!CollectionUtils.isEmpty(list)) {
					mv.addObject("drugList", list);
				    mv.setViewName("Manger/drug_manage");
					mv.addObject("searchMess", searchMess);
				   return mv;
				}
			}
			searchFailManger(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("Manger/drug_manage");
		return mv;
	}


	@RequestMapping("/admin/edit")
	public  ModelAndView  editDrug(Integer id){
		ModelAndView mv = new ModelAndView("Manger/drug_edit");
		try {
			Drug  d=this.drugService.findById(id);
			mv.addObject("drug", d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/admin/delete")
	public  String  deleteDrug(int  id,HttpServletRequest request, HttpServletResponse response){
		try {
			this.drugService.deleteDrugById(id);
			successDelete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Manger/drug_manage";
	}

	public void successDelete(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('下架成功'); </script>");
			out.print("<script> window.location.href=' http://localhost:8080/drug/admin/queryAll/0'  </script>");
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
			out.print("<script> window.location.href=' http://localhost:8080/drug/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
	public void searchFailManger(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('搜索无结果，请输入其他关键字'); </script>");
			out.print("<script> window.location.href='http://localhost:8080/drug/admin/queryAll/0'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * @param request
	 * @param response
	 * @Description
	 */
	public void successToShoppingCar(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('加入成功'); </script>");
			out.print("<script> window.location.href='http://localhost:8080/drug/user/findAll'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	public void searchFail(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script> alert('搜索无结果，请输入其他关键字'); </script>");
			out.print("<script> window.location.href='http://localhost:8080/goodhealth/index.jsp'  </script>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
