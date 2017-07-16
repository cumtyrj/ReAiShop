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
		String password="111";
		User user=userService.login(loginname, password);
		System.out.println(user);
		}
}
