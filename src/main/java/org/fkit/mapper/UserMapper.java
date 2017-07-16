package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.domain.Cart;
import org.fkit.domain.Good;
import org.fkit.domain.User;

/**
 * UserMapper接口
 * */
public interface UserMapper {
	
	/**
	 * 根据登录名和密码查询用户
	 * @param String loginname
	 * @param String password
	 * @return 找到返回User对象，没有找到返回null
	 * */
	//登录
	@Select("select * from tb_user where loginname = #{loginname} and password = #{password}")
	User findWithLoginnameAndPassword(@Param("loginname")String loginname,
			@Param("password") String password);

	//注册
	 @Insert("insert into tb_user(loginname,username,password,phone,email,card) values(#{loginname},#{username},#{password},#{phone},#{email},#{card})")
	 @Options(useGeneratedKeys = true, keyProperty = "id")
	 int registerUser(User user);
	 
	//根据信息找回密码
	@Select("select * from tb_user where loginname = #{loginname} and phone = #{phone} and card=#{card}")
	User findWithLoginnameAndPhoneAndCard(@Param("loginname")String loginname,
			@Param("phone") String phone,@Param("card")String card);
	//更新密码
    @Update("update tb_user set password=#{password} where loginname=#{loginname}")
     void updatePsw(User user);
    

	//根据登录名信息
    @Select("select * from tb_user where loginname=#{loginname}")
	User findWithLoginname(@Param("loginname") String loginname);
    
    //更新信息
    @Update("update tb_user set username=#{username},phone=#{phone},email=#{email} where loginname=#{loginname}")
    void updateInf(User user);
    
}
