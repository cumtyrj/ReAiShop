package org.fkit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.fkit.domain.Cart;
import org.fkit.domain.Good;
import org.fkit.service.CartService;
import org.fkit.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	
	@RequestMapping(value="/cart")
	public String cart(Model model){
		// 获得所有图书集合
		List<Cart> cart_list = cartService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("cart_list", cart_list);
		// 跳转到cart页面s
		return "cart";
	}
	
	@RequestMapping(value = "/intocart")
	public String save(HttpServletRequest request,Model model) {
		Good good=(Good) request.getAttribute("good");
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		String name=good.getName();
		String price=good.getPrice();
		String detail=good.getDetail();
		String image=good.getImage1();
		String goodtype=good.getGoodtype();
		String num = request.getParameter("num");
		int num_ = Integer.parseInt(num);
		Cart cart=cartService.findgoodWithId(good_id_);
		if (cart == null) {
			cartService.saveCart(good_id_, price, name, detail, image,num_,goodtype);
		}else {
			int _num=cart.getNum();
			_num=_num+num_;
			cartService.addCart(good_id_,_num);	
		}
		List<Cart> cart_list = cartService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("cart_list", cart_list);
		// 跳转到main页面
		return "cart";
	}

	//清空购物车
	@RequestMapping(value = "/clear")
	public String clear(Model model) {
		cartService.clearCart();
		List<Cart> cart_list = cartService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("cart_list", cart_list);
		// 跳转到main页面
		return "cart";

	}
	//减
	@RequestMapping(value="/reduce")
	public String reduce(Model model,HttpServletRequest request){
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		cartService.reduceCart(good_id_);
		List<Cart> cart_list = cartService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("cart_list", cart_list);
		// 跳转到cart页面
		return "cart";
	}
	
	//加
	@RequestMapping(value="/add")
	public String add(Model model,HttpServletRequest request){
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		cartService.addoneCart(good_id_);
		List<Cart> cart_list = cartService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("cart_list", cart_list);
		// 跳转到cart页面
		return "cart";
	}
	//删除购物车的东西
	@RequestMapping(value="/remove")
	public String remove(Model model,HttpServletRequest request){
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		cartService.removeCart(good_id_);
		List<Cart> cart_list = cartService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("cart_list", cart_list);
		// 跳转到cart页面
		return "cart";
	}
	
	//从购物车获取商品信息
	@RequestMapping(value="/saveorder")
	public String allGood(HttpServletRequest request,Model model, ServletResponse response) throws ServletException, IOException{
		Integer good_id=Integer.parseInt(request.getParameter("good_id"));
		Cart cart=cartService.findgoodWithId(good_id);
		request.setAttribute("cart", cart);
		RequestDispatcher rd = request.getRequestDispatcher("intoorder"); 
		rd.forward(request,response); 
		return "order";
	
	}

}
