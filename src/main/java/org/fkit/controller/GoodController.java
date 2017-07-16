package org.fkit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.fkit.domain.Good;
import org.fkit.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class GoodController {
	/**
	 * 自动注入BookService
	 * */
	@Autowired
	@Qualifier("goodService")
	private GoodService goodService;

	/**
	 * 处理href请求
	 * @param response 
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	//根据good_id获取商品信息
	@RequestMapping(value="/save")
	public String allGood(HttpServletRequest request,Model model, ServletResponse response) throws ServletException, IOException{
		Integer good_id=Integer.parseInt(request.getParameter("good_id"));
		Good good=goodService.selectByGoodId(good_id);
		request.setAttribute("good", good);
		RequestDispatcher rd = request.getRequestDispatcher("intocart"); 
		rd.forward(request,response); 
		return "cart";	
	}
	//立即购买获取信息
	@RequestMapping(value="/savedirectly")
	public String allGooddirectly(HttpServletRequest request,Model model, ServletResponse response) throws ServletException, IOException{
		Integer good_id=Integer.parseInt(request.getParameter("good_id"));
		Good good=goodService.selectByGoodId(good_id);
		request.setAttribute("good", good);
		RequestDispatcher rd = request.getRequestDispatcher("orderdirectly"); 
		rd.forward(request,response); 
		return "goodetail";	
	}
	//获取商品信息
	@RequestMapping(value="/savecollect")
	public String getGood(HttpServletRequest request,Model model, ServletResponse response) throws ServletException, IOException{
		Integer good_id=Integer.parseInt(request.getParameter("good_id"));
		Good good=goodService.selectByGoodId(good_id);
		request.setAttribute("good", good);
		RequestDispatcher rd = request.getRequestDispatcher("intocollect"); 
		rd.forward(request,response); 
		return "collection";
	
	}

	
	// 椅子
	@RequestMapping(value="/chair")
	 public String wenyibook(Model model){
		// 获得所有椅子集合
		String goodtype="chair";
		List<Good> chair_list = goodService.chairgetAll(goodtype);
		// 将椅子集合添加到model当中
		model.addAttribute("chair_list", chair_list);
		// 跳转到椅子页面
		return "chair";
	}
	
	//书架
	@RequestMapping(value="/bookcase")
	 public String bookcase(Model model){
		// 获得所有书架集合
		String goodtype="bookcase";
		List<Good> bookcase_list = goodService.bookcasegetAll(goodtype);
		// 将书架集合添加到model当中
		model.addAttribute("bookcase_list", bookcase_list);
		// 跳转到书架页面
		return "bookcase";
	}
	

	@RequestMapping(value="/vessel")
	 public String vessel(Model model){
		// 获得所有器皿集合
		String goodtype="vessel";
		List<Good> vessel_list = goodService.vesselgetAll(goodtype);
		// 将器皿集合添加到model当中
		model.addAttribute("vessel_list", vessel_list);
		// 跳转到器皿页面
		return "vessel";
	}
	

	@RequestMapping(value="/tool")
	 public String tool(Model model){
		// 获得所有用具集合
		String goodtype="tool";
		List<Good> tool_list = goodService.toolgetAll(goodtype);
		// 将用具集合添加到model当中
		model.addAttribute("tool_list", tool_list);
		// 跳转到用具页面
		return "tool";
	}
	
	@RequestMapping(value = "/mnggood")
	public String mnggood(Model model) {
		
		// 获得所有图书集合
		List<Good> good_list =goodService.getAll();
		
		model.addAttribute("good_list", good_list);
		// 跳转到cart页面
		return "mnggood";
	
	}
	@RequestMapping(value = "/mngxskc")
	public String mngxskc(Model model) {
		
		// 获得所有图书集合
		List<Good> xskc_list =goodService.getAll();
		
		model.addAttribute("xskc_list", xskc_list);
		// 跳转到cart页面
		return "mngxskc";
	
	}

//管理员添加商品
	@RequestMapping(value = "/addnewgood")
	public String addnewgood(Model model,HttpServletRequest request) {
		String name=request.getParameter("name");
		String goodtype=request.getParameter("goodtype");
		String price=request.getParameter("price");
		String detail=request.getParameter("detail");
		Integer inventory=Integer.parseInt(request.getParameter("inventory"));
		// 获得所有图书集合
		Good good=goodService.addnewGood(name, goodtype, price, detail, inventory);
		// 跳转到cart页面
		request.setAttribute("good", good);
		List<Good> good_list =goodService.getAll();
		
		model.addAttribute("good_list", good_list);
		return "mnggood";
	
	}
	

//管理员删除商品
	@RequestMapping(value="/mngremovegood")
	public String removenewgood(Model model,HttpServletRequest request){
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		goodService.mngremoveGood(good_id_);
		// 跳转到cart页面
		List<Good> good_list =goodService.getAll();
		model.addAttribute("good_list", good_list);
		return "mnggood";
	}
//管理员修改商品
	@RequestMapping(value = "/mnggetgoodinf")
	public String getGoodInf( ServletResponse response,HttpServletRequest request) throws ServletException, IOException {
//		Good good=(Good) request.getAttribute("good");
//		String name=good.getName();
//		String price=good.getPrice();
//		String detail=good.getDetail();
//		String goodtype=good.getGoodtype();
//		int inventory=good.getInventory();
//		goodService.selectByGoodId(good_id_);
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		Good good=goodService.selectByGoodId(good_id_);
		request.setAttribute("good", good);
		RequestDispatcher rd = request.getRequestDispatcher("mngupdgood"); 
		rd.forward(request,response); 
		return "mnggood";
}
	@RequestMapping(value = "/mngupdgood")
	public String updateIn( ModelAndView mv,HttpSession session,HttpServletRequest request,Model model,String name,String price,String detail,String goodtype,Integer inventory) {
	
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		goodService.selectByGoodId(good_id_);
		goodService.mngupdgood(good_id_, name, goodtype, price, detail, inventory);
		List<Good> good_list =goodService.getAll();
		model.addAttribute("good_list", good_list);
		return "mngchangegood";
}
	//查看商品详情
	@RequestMapping(value="/lookupgood")
	public String lookupgood(ServletResponse response,HttpServletRequest request)throws ServletException, IOException {
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		Good good=goodService.selectByGoodId(good_id_);
		request.setAttribute("good", good);
		// 跳转到cart页面
//		List<Good> good_list =goodService.getAll();
//		model.addAttribute("good_list", good_list);
		return "gooddetail";
		}
	}