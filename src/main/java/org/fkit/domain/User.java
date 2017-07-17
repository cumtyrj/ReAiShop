package org.fkit.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;



/**
 * CREATE TABLE tb_user(
id INT PRIMARY KEY AUTO_INCREMENT,      #id
loginname VARCHAR(50) UNIQUE,		#登录名 邮箱
PASSWORD VARCHAR(18),			#密码
username VARCHAR(18),			#用户名
phone VARCHAR(18),			#电话
address VARCHAR(255)			#地址
);
 * */
public class User implements Serializable{
	private Integer user_id;			// id
	@NotBlank
	private String loginname;	// 登录名
	
	private String password;	// 密码

	private String username;	// 用户名
	
	private String phone;		// 电话
	
	private String email;
	
	private String card;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUserId() {
		return user_id;
	}
	public void setId(Integer user_id) {
		this.user_id = user_id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", loginname=" + loginname + ", username=" + username + ",password="+ password + ", phone=" + phone+ ", email=" + email + ",card="+ card + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public User( String loginname, String username, String password,String phone,String email,String card) {
		super();
		this.loginname=loginname;
		this.username=username;
		this.card=card;
		this.phone=phone;
		this.email=email;
		this.password=password;

	}


}