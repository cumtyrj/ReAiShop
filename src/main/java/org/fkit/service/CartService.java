package org.fkit.service;

import java.util.List;
import org.fkit.domain.Cart;

public interface CartService {
	List<Cart> getAll();
	Cart findgoodWithId(int good_id);
	Cart addCart(int good_id,int num);
	Cart addoneCart(int good_id);
	Cart reduceCart(int good_id);
	Cart removeCart(int good_id);
	void clearCart();
	void saveCart(int good_id,String price,String name,String detail,String image,int num,String goodtype,int user_id);
}
