package org.fkit.service.impl;

import org.fkit.domain.User;
import org.fkit.mapper.UserMapper;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User服务层接口实现类
 * @Service("userService")用于将当前类注释为一个Spring的bean，名为userService
 * */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {
	
	/**
	 * 自动注入UserMapper
	 * */
	@Autowired
	private UserMapper userMapper;

	/**
	 * UserService接口login方法实现
	 * @see { UserService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password) {
		return userMapper.findWithLoginnameAndPassword(loginname, password);
	}
	
	@Override
	public User register(String username,String loginname,String password,String phone,String email,String card) {
		User user=new User();
		user.setLoginname(loginname);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCard(card);
		userMapper.registerUser(user);
		return user;
	}


	//认证修改密码
	@Transactional(readOnly=true)
	@Override
	public User findpsw(String loginname, String phone,String card) {
		return userMapper.findWithLoginnameAndPhoneAndCard(loginname, phone, card);
	}
	//更新

	@Override
	public void updetepsw(String password,String loginname) {
		// TODO Auto-generated method stub
		User user=userMapper.findWithLoginname(loginname);
		user.setLoginname(loginname);
		user.setPassword(password);
		userMapper.updatePsw(user);
	}



	@Override
	public User findloginname(String loginname) {
		// TODO Auto-generated method stub
		
		return userMapper.findWithLoginname(loginname);
	}

	@Override
	public User updateInf(String email, String username, String phone,String loginname) {
		// TODO Auto-generated method stub
		User user=userMapper.findWithLoginname(loginname);
		user.setEmail(email);
		user.setPhone(phone);
		user.setUsername(username);
		userMapper.updateInf(user);
		return user;
	}

	@Override
	public User lgnemail(String loginname, String email) {
		// TODO Auto-generated method stub
		return userMapper.lgnemail(loginname, email);
	}

	@Override
	public User goodemail(int user_id) {
		// TODO Auto-generated method stub
		return userMapper.goodemail(user_id);
	}


}
