package org.fkit.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.fkit.domain.Cart;
import org.fkit.domain.Good;
import org.fkit.domain.Order;
import org.fkit.domain.User;
import org.fkit.service.GoodService;
import org.fkit.service.OrderService;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import SimpleDateFormat.GenerateNum;

@Controller
public class OrderController {
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	@Autowired
	@Qualifier("goodService")
	private GoodService goodService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value="/order")
	public String order(Model model){
		List<Order> order_list = orderService.getAll();
		model.addAttribute("order_list", order_list);
		return "order";
	}
	
	//商家查看评价
	@RequestMapping(value="/mngcommit")
	public String mngordercommit(Model model, String wuliu){		
		List<Order> order_list = orderService.getAll();
		model.addAttribute("order_list", order_list);
		return "mngcommit";
	}
	
	//评价
	@RequestMapping(value="/commitorder")
	public String commitorder(Model model){
		String state="已发货";
		orderService.findByState(state);
		List<Order> order_list = orderService.findByState(state);
		model.addAttribute("order_list", order_list);
		return "commitorder";
	}

	//根据good_id获取商品信息
	@RequestMapping(value = "/intoorder")
	public String save(HttpServletRequest request,Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
//		int user_id=user.getUserId();
		Cart cart=(Cart) request.getAttribute("cart");
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		String loginname=user.getLoginname();
		String name=cart.getName();
		String price=cart.getPrice();
		int num=cart.getNum();
		Integer price_=Integer.parseInt(price.trim());
		String detail=cart.getDetail();
		String image=cart.getImage();
		String goodtype=cart.getGoodtype();
		int account=price_*num;
//		orderService.findgoodWithId(good_id_);
		String ordernum=GenerateNum.getInstance().GenerateOrder();
		String state="未发货";
		orderService.saveOrder(good_id_,price, name, detail, image, num, goodtype,account,loginname,ordernum,state);		
		Good good1=goodService.selectByGoodId(good_id_);
		int sales=good1.getSales();
		sales=sales+num;
		goodService.addSales(good_id_, sales);
		int inventory=good1.getInventory();
		inventory=inventory-num;
		goodService.reduceInventory(good_id_,inventory);
		List<Order> order_list = orderService.getAll();
		model.addAttribute("order_list", order_list);
		return "order";
	}
	
	//立即购买
	@RequestMapping(value = "/orderdirectly")
	public String savedirectly(HttpServletRequest request,Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
//		int user_id=user.getUserId();
		Good good=(Good) request.getAttribute("good");
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		String loginname=user.getLoginname();
		String name=good.getName();
		String price=good.getPrice();
		String detail=good.getDetail();
		String image=good.getImage1();
		String goodtype=good.getGoodtype();
		String num = request.getParameter("num");
		int num_ = Integer.parseInt(num);
		Integer price_=Integer.parseInt(price.trim());
		int account=price_*num_;
//		orderService.findgoodWithId(good_id_);
		String ordernum=GenerateNum.getInstance().GenerateOrder();
		String state="未发货";
		orderService.saveOrder(good_id_,price, name, detail, image, num_, goodtype,account,loginname,ordernum,state);		
		Good good1=goodService.selectByGoodId(good_id_);
		int sales=good1.getSales();
		sales=sales+num_;
		goodService.addSales(good_id_, sales);
		int inventory=good1.getInventory();
		inventory=inventory-num_;
		goodService.reduceInventory(good_id_,inventory);
		List<Order> order_list = orderService.getAll();
		model.addAttribute("order_list", order_list);
		return "order";
	}
	
	//根据订单号获取订单信息
	@RequestMapping(value="/mngsendgoodnum")
	public String mnggetGood(HttpServletRequest request,Model model, ServletResponse response) throws ServletException, IOException{
	    String ordernum=request.getParameter("ordernum");
		Order order=orderService.findByOrdernum(ordernum);
		request.setAttribute("order", order);
		RequestDispatcher rd = request.getRequestDispatcher("mngsendgood"); 
		rd.forward(request,response); 
		return "mngorder";
	
	}
	//根据id获取评价信息
	@RequestMapping(value="/commitgetorder")
	public String commitgetGood(HttpServletRequest request,String wuliu,Model model, ServletResponse response, String zhiliang, String fuwu) throws ServletException, IOException{
	    String ordernum=request.getParameter("ordernum");
		orderService.findByOrdernum(ordernum);
		orderService.commitorder(wuliu, zhiliang, fuwu, ordernum);
			List<Order> order_list = orderService.getAll();
			// 将图书集合添加到model当中
			model.addAttribute("order_list", order_list);		
		return "order";
	
	}
	//清空购物车
	@RequestMapping(value = "/clearorder")
	public String clear(Model model) {
		orderService.clearOrder();
		List<Order> order_list = orderService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("order_list", order_list);
		// 跳转到main页面
		return "order";

	}
	//取消购物车的东西
	@RequestMapping(value="/removeorder")
	public String remove(Model model,HttpServletRequest request){
			String ordernum = request.getParameter("ordernum");
			orderService.removeOrder(ordernum);
			List<Order> order_list = orderService.getAll();
			// 将图书集合添加到model当中
			model.addAttribute("order_list", order_list);
			// 跳转到cart页面
			return "order";
			
	}
	
	//查询订单
	@RequestMapping(value="/selectorder")
	public String selectcollect(Model model,HttpServletRequest request){
		String ordernum=request.getParameter("ordernum");
		List<Order> selectorder_list = orderService.findWithOrdernum(ordernum);
		// 将书架集合添加到model当中
		model.addAttribute("selectorder_list", selectorder_list);
		return "selectorder";
	}
//添加到商家的订单管理
	@RequestMapping(value="/mngorder")
	public String mngorder(Model model,HttpServletRequest request){
	List<Order> order_list = orderService.getAll();
	// 将图书集合添加到model当中
	model.addAttribute("order_list", order_list);
	// 跳转到main页面
	return "mngorder";
	}
	
//发货
	@RequestMapping(value="/mngsendgood")
	public String mngsendorder(Model model,HttpServletRequest request,String state){
			
		String ordernum=request.getParameter("ordernum");
		orderService.findWithOrdernum(ordernum);
		//String state="已发货";
		orderService.updstate(state, ordernum);
		List<Order> order_list = orderService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("order_list", order_list);
		return "mngorder";		
	}

}