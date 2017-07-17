package org.fkit.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.fkit.domain.Collect;
import org.fkit.domain.Good;
import org.fkit.domain.User;
import org.fkit.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CollectController {
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Autowired 
	@Qualifier("collectService")
	private CollectService collectService;
	
	@RequestMapping(value="/collection")
	public String cart(Model model, HttpSession session){
		// 获得所有图书集合
		User user=(User) session.getAttribute("user");
		Integer user_id=user.getUserId();
		List<Collect> collect_list = collectService.getCollectByUserid(user_id);
		// 将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		// 跳转到cart页面s
		return "collection";
	}
	
	@RequestMapping(value = "/intocollect")
	public String save(HttpServletRequest request,Model model, HttpSession session) {
		User user=(User) session.getAttribute("user");
		Integer user_id=user.getUserId();
		Good good=(Good) request.getAttribute("good");
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		String name=good.getName();
		String price=good.getPrice();
		String detail=good.getDetail();
		String image=good.getImage1();
		String goodtype=good.getGoodtype();
		Collect collect=collectService.findgoodWithId(good_id_);
		if (collect==null){
			collectService.saveCollect(good_id_, price, name, detail, image, goodtype,user_id);
		}else{
			model.addAttribute("message", "收藏夹已有该商品请勿重复加入!");
		}
		List<Collect> collect_list = collectService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		// 跳转到main页面
		return "collection";
	}

	//清空购物车
	@RequestMapping(value = "/clearcollect")
	public String clear(Model model) {
		collectService.clearCollect();
		List<Collect> collect_list = collectService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		// 跳转到main页面
		return "collection";

	}
	//取消购物车的东西
	@RequestMapping(value="/removecollect")
	public String remove(Model model,HttpServletRequest request){
		String good_id = request.getParameter("good_id");
		int good_id_ = Integer.parseInt(good_id);
		collectService.removeCollect(good_id_);
		List<Collect> collect_list = collectService.getAll();
		// 将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		// 跳转到cart页面
		return "collection";
	}
	

}
