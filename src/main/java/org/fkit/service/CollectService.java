package org.fkit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fkit.domain.Cart;
import org.fkit.domain.Collect;
import org.fkit.domain.Good;

public interface CollectService {
	List<Collect> getAll();
	List<Collect> getCollectByUserid(int user_id);
	Collect findgoodWithId(int good_id);
	Collect removeCollect(int good_id);
	void clearCollect();
	void saveCollect(int good_id,String price,String name,String detail,String image,String goodtype,int user_id);
}
