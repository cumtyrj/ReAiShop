package org.fkit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fkit.domain.Cart;
import org.fkit.domain.Good;

public interface CartService {
	List<Cart> getAll();
	Cart findgoodWithId(int good_id);
	Cart addCart(int good_id,int num);
	Cart addoneCart(int good_id);
	Cart reduceCart(int good_id);
	Cart removeCart(int good_id);
	void clearCart();
	void saveCart(int good_id,String price,String name,String detail,String image,int num,String goodtype);
}
