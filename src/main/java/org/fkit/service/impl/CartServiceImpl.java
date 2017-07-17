package org.fkit.service.impl;

import java.util.List;
import org.fkit.domain.Cart;
import org.fkit.mapper.CartMapper;
import org.fkit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartMapper cartMapper;
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return cartMapper.findAll();
	}

	@Override
	public Cart findgoodWithId(int good_id) {
		// TODO Auto-generated method stub
		return cartMapper.findWithId(good_id);
	}



	@Override
	public Cart addCart(int good_id,int num) {
		// TODO Auto-generated method stub
		Cart cart = cartMapper.findWithId(good_id);
		cart.setNum(num);
		cartMapper.addCart(cart);
		return cart;
	}
	
	@Override
	public Cart addoneCart(int good_id) {
		// TODO Auto-generated method stub
		Cart cart = cartMapper.findWithId(good_id);
		cartMapper.addoneCart(cart);
		return cart;
	}
	@Override
	public Cart reduceCart(int good_id) {
		// TODO Auto-generated method stub
		Cart cart = cartMapper.findWithId(good_id);
		if (cart.getNum()>= 2) {
			cartMapper.reduceCart(cart);
		} else {
			cartMapper.removeCart(cart);
		}
		return cart;
	}

	@Override
	public Cart removeCart(int good_id) {
		// TODO Auto-generated method stub
		Cart cart = cartMapper.findWithId(good_id);
		cartMapper.removeCart(cart);
		return cart;
	}

	@Override
	public void clearCart() {
		cartMapper.clearCart();
		
	}


	@Override
	public void saveCart(int good_id, String price, String name, String detail, String image,int num,String goodtype,int user_id) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setGood_id(good_id);
//		final int i = 1;
//		cart.setNum(i);
		cartMapper.saveCart(good_id, price, name, detail, image,num ,goodtype);
	}


}
