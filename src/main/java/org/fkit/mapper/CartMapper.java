package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.domain.Cart;

public interface CartMapper {
	    
	@Select("select * from tb_cart")
	List<Cart> findAll();

	    //加入购物车
	    @Insert("insert into tb_cart(good_id,name,price,detail,image,num,goodtype) values(#{good_id},#{name},#{price},#{detail},#{image1},#{num},#{goodtype})")
		void saveCart(@Param("good_id") int good_id,@Param("price")String price,@Param("name")String name,@Param("detail")String detail,@Param("image1")String image1,@Param("num")int num,@Param("goodtype")String goodtype);
         //通过ID寻找物品
	    @Select("select * from tb_cart where good_id=#{good_id}")
		Cart findWithId(@Param("good_id") int good_id);
        //增加多个数量
	    @Update("update tb_cart set num=#{num} where good_id=#{good_id}")
		void addCart(Cart cart);
	    //增加一个
	    @Update("update tb_cart set num=num+1 where good_id=#{good_id}")
		void addoneCart(Cart cart);
	    //清空购物车
		@Delete("delete from tb_cart ")
		void clearCart();
	    //减少数量
		@Update("update tb_cart set num=num-1 where good_id=#{good_id}")
		void reduceCart(Cart cart);
		//删除商品
		@Delete("delete from tb_cart where good_id=#{good_id}")
		void removeCart(Cart cart);
}
