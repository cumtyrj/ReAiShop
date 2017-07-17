package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.domain.Order;

public interface OrderMapper {
	    
	@Select("select * from tb_order")
	List<Order> findAll();

	    //加入购物车
	    @Insert("insert into tb_order(good_id,name,price,detail,image,num,goodtype,account,loginname,ordernum,state,user_id) values(#{good_id},#{name},#{price},#{detail},#{image},#{num},#{goodtype},#{account},#{loginname},#{ordernum},#{state},#{user_id})")
		void saveOrder(@Param("good_id") int good_id,@Param("price")String price,@Param("name")String name,@Param("detail")String detail,@Param("image")String image,@Param("num")int num,@Param("goodtype")String goodtype,@Param("account")int account,@Param("loginname")String loginname,@Param("ordernum")String ordernum,@Param("state")String state,@Param("user_id")int uder_id);
         //通过ID寻找物品
	    @Select("select * from tb_order where good_id=#{good_id}")
	    Order findWithId(@Param("good_id") int good_id);
	    //清空购物车
		@Delete("delete from tb_order ")
		void clearOrder();
		//删除商品
		@Delete("delete from tb_order where ordernum=#{ordernum}")
		void removeOrder(Order order);
		//通过订单号查询物品
	    @Select("select * from tb_order where ordernum=#{ordernum}")
	    List<Order> findWithOrdernum(@Param("ordernum")String ordernum);
        //通过订单号寻找物品
	    @Select("select * from tb_order where ordernum=#{ordernum}")
	    Order findByOrdernum(@Param("ordernum") String ordernum);
	    //更新物流
	    @Update("update tb_order set state=#{state} where ordernum=#{ordernum}")
	    void updstate(Order order);
	    //查看状态
	    @Select("select * from tb_order where state=#{state}")
	    List<Order> findByState(@Param("state") String state);
	    //订单评分
	    @Update("update  tb_order set wuliu=#{wuliu},zhiliang=#{zhiliang},fuwu=#{fuwu} where ordernum=#{ordernum}")
		void commitorder(Order order);
	    //管理评价
	    @Select("select * from tb_order where wuliu=#{wuliu}")
	    List<Order> findByWuliu(@Param("wuliu") String wuliu);
	    
	    @Update("update tb_order set num=num+1 where good_id=#{good_id}")
		void addCart(Order order);
}
