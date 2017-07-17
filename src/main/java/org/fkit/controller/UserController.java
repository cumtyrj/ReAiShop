package org.fkit.controller;


import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import org.fkit.domain.User;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * 处理用户请求控制器
 * */
@Controller
public class UserController {
	
	/**
	 * 自动注入UserService
	 * */
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/login")
	 public ModelAndView login( HttpServletResponse response, 
			 String loginname,String password,
			 ModelAndView mv,
			 HttpSession session){
		// 根据登录名和密码查找用户，判断用户登录
		if(loginname.length()==0){
			mv.addObject("message", "用户名不能为空，请重新输入!");
			mv.setViewName("loginForm");
		}else if(password.length()==0)
		{
			mv.addObject("message", "密码不能为空，请重新输入!");
			mv.setViewName("loginForm");
		}else{
		User user = userService.login(loginname, password);
		if(user != null){
			// 登录成功，将user对象设置到HttpSession作用范围域
			session.setAttribute("user", user);
			// 转发到main请求
			mv.setViewName("index");
		}else{
			// 登录失败，设置失败提示信息，并跳转到登录页面
			mv.addObject("message", "登录名或密码错误，请重新输入!");
			mv.setViewName("loginForm");
		}
		}
		return mv;
	}
	
//管理员登录
	@RequestMapping(value="/mnglogin")
	 public ModelAndView mnglogin( HttpServletResponse response, 
			 String loginname,String password,
			 ModelAndView mv,
			 HttpSession session){
		// 根据登录名和密码查找用户，判断用户登录

		User user = userService.login(loginname, password);
		if(user != null){
			// 登录成功，将user对象设置到HttpSession作用范围域
			session.setAttribute("user", user);
			// 转发到main请求
			mv.setViewName("mngindex");
		}else{
			// 登录失败，设置失败提示信息，并跳转到登录页面
			mv.addObject("message", "登录名或密码错误，请重新输入!");
			mv.setViewName("mnglogin");
		}
		return mv;
	}
	

//登出
	@RequestMapping("/loginout")
	public String loginout(HttpSession session){
		session.invalidate();
		return "loginForm";
	}
	
//管理员登出
		@RequestMapping("/mngloginout")
		public String mngloginout(HttpSession session){
			session.invalidate();
			return "loginForm";
		}
//注册	
	 @RequestMapping(value = "/register",method = RequestMethod.POST)

		public ModelAndView register(String username,
				String password,String phone,String email,String card,
				ModelAndView mv, HttpSession session,HttpServletRequest request, String user_id, String loginname) {
			// 根据输入的登录名和密码向数据库中添加新的用户信息,完成注册
			if(loginname.length()==0){
				mv.addObject("ms1", "账号不能为空，请重新输入!");
				mv.setViewName("register");
			}else if(username.length()==0)
			{
				mv.addObject("ms2", "用户名不能为空，请重新输入!");
				mv.setViewName("register");
			}else if(password.length()==0)
			{
				mv.addObject("ms3", "密码不能为空，请重新输入!");
				mv.setViewName("register");
			}else if(phone.length()==0)
			{
				mv.addObject("ms4", "电话不能为空，请重新输入!");
				mv.setViewName("register");
			}else if(email.length()==0)
			{
				mv.addObject("ms5", "邮箱为空或格式错误，请重新输入!");
				mv.setViewName("register");
			}else if(card.length()==0)
			{
				mv.addObject("ms6", "身份证不能为空，请重新输入!");
				mv.setViewName("register");
			}else{
			User user = userService.register(username,loginname,password,
						phone,email,card);
			if(user != null){
				// 登录成功，将user对象设置到HttpSession作用范围域
				session.setAttribute("user", user);
				// 转发到main请求
			mv.setViewName("loginForm");
			}else{
				// 登录失败，设置失败提示信息，并跳转到登录页面
				mv.addObject("message", "信息不全，请重新输入!");
				mv.setViewName("register");
			}
			}
			return mv;
		}

	 


	//修改个人信息
		@RequestMapping(value = "/changeInf")
		public ModelAndView updateInf( ModelAndView mv,HttpSession session,HttpServletRequest request,Model model,String usernamenew,String phonenew,String emailnew) {
			String loginname = request.getParameter("loginname");
			User user=userService.findloginname(loginname);
				userService.updateInf(emailnew, usernamenew, phonenew, loginname);
				session.setAttribute("user", user);
				mv.setViewName("owninf");
				return mv;
		

		}


		//邮件
		@RequestMapping(value="/findpsw",method = RequestMethod.POST)
		public ModelAndView find(
			String loginname,String email,
			ModelAndView mv,
			HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{					
		    User user=userService.lgnemail(loginname, email);
			if(user!=null){				
				StringBuffer url = new StringBuffer();
				StringBuilder builder = new StringBuilder();
				// 正文
				builder.append(
						"<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>");
				url.append("<font color='red'>" + user + "</font>");
				builder.append("<br/><br/>");
				builder.append("<div>" + url + "</div>");
				builder.append("</body></html>");
				SimpleEmail sendemail = new SimpleEmail();
				sendemail.setHostName("smtp.163.com");// 指定要使用的邮件服务器
				sendemail.setAuthentication("cumtsqq@163.com", "145s486q");// 使用163的邮件服务器需提供在163已注册的用户名、密码
				sendemail.setCharset("UTF-8");
				try {
					sendemail.setCharset("UTF-8");
					sendemail.addTo(email);
					sendemail.setFrom("cumtsqq@163.com");
					sendemail.setSubject("找回密码");
					sendemail.setMsg(builder.toString());
					sendemail.send();
					System.out.println(builder.toString());
				} catch (EmailException e) {
					e.printStackTrace();
				}
				response.sendRedirect("loginForm");
//				mv.setViewName("loginForm");
			}else{
				response.getWriter().println("获取密码失败");
			}
		    return null;
		}
		
		//修改密码验证
		@RequestMapping(value="/changepsw")
		 public ModelAndView changepsw( HttpServletResponse response, 
				 String loginname,String password,
				 ModelAndView mv,
				 HttpSession session){
			// 根据登录名和密码查找用户，判断用户登录

			User user = userService.login(loginname, password);
			if(user != null){
				// 登录成功，将user对象设置到HttpSession作用范围域
				session.setAttribute("user", user);
				// 转发到main请求
				mv.setViewName("newpsw");
			}else{
				// 登录失败，设置失败提示信息，并跳转到登录页面
				mv.addObject("message", "登录名或密码错误，匹配失败!");
				mv.setViewName("changepsw");
			}
			return mv;
		}
		
		@RequestMapping(value="/newpsw")
		 public String newpsw( HttpServletResponse response, 
				 String loginname,HttpServletRequest request,HttpSession session){
			String password=request.getParameter("password");
			userService.updetepsw(password, loginname);
			return "loginForm";
			
		}
}	