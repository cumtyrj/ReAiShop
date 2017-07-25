package org.fkit.service;

import java.util.List;
import org.fkit.domain.Good;

public interface GoodService {
	//椅子类
	List<Good> chairgetAll(String goodtype);
	
	//书架
	List<Good> bookcasegetAll(String goodtype);
	
	//器皿
	List<Good> 	vesselgetAll(String goodtype);
	
	//用具
	List<Good> toolgetAll(String goodtype);

	//所有
	Good selectByGoodId(int good_id);
	
			//所有用品
			List<Good> getAll();
	
	//管理员添加物品
	Good addnewGood(String name,String goodtype,String price,String detail,Integer inventory);
	
	//管理员添加图片
	Good addimage(String image);
	//管理员删除
	Good mngremoveGood(int good_id);
	//增加库存
	Good addSales(int good_id,int sales);
	//增加销售量
	Good reduceInventory(int good_id,int inventory);
	//修改商品信息
	Good mngupdgood(int good_id,String name,String goodtype,String price,String detail,Integer inventory);

}
