package org.fkit.controller;

import java.io.IOException;
import java.security.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fkit.domain.Cart;
import org.fkit.domain.Good;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

	 
//匹配信息修改密码
		@RequestMapping(value="/findpsw")
		 public ModelAndView findpsw(String loginname, String phone,String card,
				 ModelAndView mv,
				 HttpSession session){
			// 根据登录名和密码查找用户，判断用户登录
			User user = userService.findpsw(loginname, phone, card);
			if(user != null){
				// 登录成功，将user对象设置到HttpSession作用范围域
				session.setAttribute("user", user);
				// 转发到main请求
				mv.setViewName("changepsw");
			}else{
				// 登录失败，设置失败提示信息，并跳转到登录页面
				mv.addObject("message", "验证错误，请重新输入!");
				mv.setViewName("findpsw");
			}
			return mv;
		}

//获取用户信息
		@RequestMapping(value="/change")
		public String UserInf(HttpServletRequest request,Model model, ServletResponse response) throws ServletException, IOException{
			String loginname=request.getParameter("loginname");
			User user=userService.findloginname(loginname);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("changepsw"); 
			rd.forward(request,response); 
			return "changepsw";
		
		}
//修改密码
		@RequestMapping(value="/changepsw")
		 public ModelAndView changepsw(HttpServletRequest request,
				
				 ModelAndView mv,
				 HttpSession session, String user_id, String password){
			// 根据登录名和密码查找用户，判断用户登录
			User user=(User) request.getAttribute("user");
			String loginname=request.getParameter("loginname");
			user = userService.findloginname(loginname);
			//if(user!=null){
				// 登录成功，将user对象设置到HttpSession作用范围域
				userService.updetepsw(password, loginname);
				session.setAttribute("user", user);
				// 转发到main请求
				mv.setViewName("loginForm");
				mv.addObject("changepswsuccess", "修改密码成功，请登录!");
				mv.setViewName("loginForm");	
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
//		//通过邮件找回密码
//		@RequestMapping(value = "/user/i_forget_password")
//		@ResponseBody
//		public Map forgetPass(HttpServletRequest request,String loginname){
//		    User user = userService.findloginname(loginname);
//		    try{
//		        String secretKey= UUID.randomUUID().toString();  //密钥
//		        Timestamp outDate = new Timestamp(System.currentTimeMillis()+30*60*1000);//30分钟后过期
//		        long date = outDate.getTime();/1000*1000;                  //忽略毫秒数
//		        users.setValidataCode(secretKey);
//		        users.setRegisterDate(outDate);
//		        userService.update(users);    //保存到数据库
//		        String key = user.getLoginname()+"$"+date+"$"+secretKey;
//		        String digitalSignature = MD5.MD5Encode(key);                 //数字签名
//		 
//		        String emailTitle = "有方云密码找回";
//		        String path = request.getContextPath();
//		        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//		        String resetPassHref =  basePath+"user/reset_password?sid="+digitalSignature+"&userName="+users.getUserName();
//		        String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href="+resetPassHref +" target='_BLANK'>点击我重新设置密码</a>" +
//		                "<br/>tips:本邮件超过30分钟,链接将会失效，需要重新申请'找回密码'"+key+"\t"+digitalSignature;
//		        System.out.print(resetPassHref);
//		        SendMail.getInstatnce().sendHtmlMail(emailTitle,emailContent,users.getEmail());
//		        msg = "操作成功,已经发送找回密码链接到您邮箱。请在30分钟内重置密码";
//		        logInfo(request,userName,"申请找回密码");
//		    }catch (Exception e){
//		        e.printStackTrace();
//		        msg="邮箱不存在？未知错误,联系管理员吧。";
//		    }
//		    map.put("msg",msg);
//		    return map;
//		}

}	