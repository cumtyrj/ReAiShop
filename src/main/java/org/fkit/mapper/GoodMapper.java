package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.domain.Good;

public interface GoodMapper {
	//通过ID查询物品
	@Select("select * from tb_goods where good_id=#{good_id}")
	Good selectByGoodId(@Param("good_id") int good_id);
	
	
	//查询所有椅子的集合
	@Select("select * from tb_goods where goodtype=#{goodtype}")
	List<Good> chairfindAll(@Param("goodtype") String goodtype);
	
	//查询所有书架
	@Select("select * from tb_goods where goodtype=#{goodtype}")
	List<Good> bookcasefindAll(@Param("goodtype") String goodtype);
	
	//查询所有器皿
	@Select("select * from tb_goods where goodtype=#{goodtype}")
	List<Good> vesselfindAll(@Param("goodtype") String goodtype);
	
	//查询所有用具
	@Select("select * from tb_goods where goodtype=#{goodtype}")
	List<Good> toolfindAll(@Param("goodtype") String goodtype);
	
	//所有物品
	@Select(" select * from tb_goods ")
	List<Good> findAll();
	
	//管理员添加物品
	 @Insert("insert into tb_goods(name,detail,inventory,goodtype,price) values(#{name},#{detail},#{inventory},#{goodtype},#{price})")
	 void addnewGood(@Param("name")String name,@Param("detail")String detail,@Param("inventory")Integer inventory,@Param("goodtype")String goodtype,@Param("price")String price);
	 
	//管理员上传图片
	 @Insert("insert into tb_goods(image)values(#{image}")
	 void addimage(@Param("image")String image);
	//管理员删除商品
	@Delete("delete from tb_goods where good_id=#{good_id}")
	void mngremoveGood(Good good);
	
    //增加销售量
	@Update("update tb_goods set sales=#{sales} where good_id=#{good_id}")
	void addSales(Good good);
	
	//减少库存量
	@Update("update tb_goods set inventory=#{inventory} where good_id=#{good_id}")
	void reduceInventory(Good good);
	
	//更新物品信息
    @Update("update tb_goods set name=#{name},detail=#{detail},inventory=#{inventory},goodtype=#{goodtype},price=#{price} where good_id=#{good_id}")
    void mngupdGood(Good good);

}