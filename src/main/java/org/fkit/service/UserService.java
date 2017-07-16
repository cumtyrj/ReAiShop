package org.fkit.service;

import java.util.List;

import org.fkit.domain.User;

public interface UserService {
	User login(String loginname,String password);
	User register(String username,String loginname,String password,String phone,String email,String card);
	User findpsw(String loginname, String phone,String card);
	User findloginname(String loginname);
	User updateInf(String email, String username, String phone, String loginname);
	void updetepsw(String password, String loginname);

}
