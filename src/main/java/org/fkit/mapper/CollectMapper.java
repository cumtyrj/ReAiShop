package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Cart;
import org.fkit.domain.Collect;

public interface CollectMapper {
	//删除商品
    @Delete("delete from tb_collection where good_id=#{good_id}")
	void removeCollect(Collect collect);
    
    //收藏夹
    @Select("select * from tb_collection")
	List<Collect> findAll();
    
    //user_id查看收藏
    @Select("select * from tb_collection where user_id=#{user_id}")
	List<Collect> getCollectByUserid(int user_id);
    
    //通过ID寻找书
    @Select("select * from tb_collection where good_id=#{good_id}")
	Collect findWithId(@Param("good_id") int good_id);
   //进行收藏
    @Insert("insert into tb_collection(good_id,name,price,detail,image,goodtype,user_id) values(#{good_id},#{name},#{price},#{detail},#{image1},#{goodtype},#{user_id})")
	void saveCollect(@Param("good_id") int good_id,@Param("price")String price,@Param("name")String name,@Param("detail")String detail,@Param("image1")String image1,@Param("goodtype")String goodtype,@Param("user_id")int user_id);

    //清空收藏
    @Delete("delete from tb_collection ")
	void clearCollect();
    //
	//删除商品
	@Delete("delete from tb_collection where good_id=#{good_id}")
	void removeCart(Cart cart);
}
