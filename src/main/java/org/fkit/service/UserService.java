package org.fkit.service;


import org.fkit.domain.User;

public interface UserService {
	User login(String loginname,String password);
	User register(String username,String loginname,String password,String phone,String email,String card);
	User findpsw(String loginname, String phone,String card);
	User findloginname(String loginname);
	User updateInf(String email, String username, String phone, String loginname);
	void updetepsw(String password, String loginname);
	User lgnemail(String loginname,String email);
	User goodemail(int user_id);
}
