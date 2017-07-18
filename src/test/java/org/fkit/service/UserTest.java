package org.fkit.service;


import org.fkit.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseJunitTest {
	@Autowired
	private UserService userService;
	@Test
	public void test1() {
		String loginname="111";
		String password="222";
		User user=userService.login(loginname, password);
		System.out.println(user);
		}
	
	@Test
	public void test2() {
		String loginname="111";
		userService.findloginname(loginname);
		String password1="111";
		userService.updetepsw(password1, loginname);
		User user=userService.findloginname(loginname);
		System.out.println(user);
		}
}
