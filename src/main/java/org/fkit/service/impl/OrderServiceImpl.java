package org.fkit.service.impl;

import java.util.List;

import org.fkit.domain.Cart;
import org.fkit.domain.Collect;
import org.fkit.domain.Good;
import org.fkit.domain.Order;
import org.fkit.domain.User;
import org.fkit.mapper.CartMapper;
import org.fkit.mapper.OrderMapper;
import org.fkit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return orderMapper.findAll();
	}

	@Override
	public Order findgoodWithId(int good_id) {
		// TODO Auto-generated method stub
		return orderMapper.findWithId(good_id);
		}

	@Override
	public Order removeOrder(String ordernum) {
		// TODO Auto-generated method stub
		Order order = orderMapper.findByOrdernum(ordernum);
		orderMapper.removeOrder(order);
		return order;
	}

	@Override
	public void clearOrder() {
		// TODO Auto-generated method stub
		orderMapper.clearOrder();
	}

	@Override
	public void saveOrder(int good_id, String price, String name, String detail, String image,
			 int num,String goodtype,int account,String loginname,String ordernum,String state) {
		Order Order = new Order();
		Order.setGood_id(good_id);
//		Order.setUser_id(user_id);
		orderMapper.saveOrder(good_id, price, name, detail, image, num, goodtype,account,loginname,ordernum,state);

	}

	@Override
	public List<Order> findWithOrdernum(String ordernum) {
		// TODO Auto-generated method stub
		return orderMapper.findWithOrdernum(ordernum);
	}

	@Override
	public void updstate(String state,String ordernum) {
		// TODO Auto-generated method stub
		Order order = orderMapper.findByOrdernum(ordernum);
		order.setState("已发货");
		orderMapper.updstate(order);
	}

	@Override
	public Order findByOrdernum(String ordernum) {
		// TODO Auto-generated method stub
		return orderMapper.findByOrdernum(ordernum);
	}

	@Override
	public List<Order> findByState(String state) {
		// TODO Auto-generated method stub
		return orderMapper.findByState(state);
	}


	@Override
	public void commitorder(String wuliu, String zhiliang, String fuwu, String ordernum) {
		// TODO Auto-generated method stub
		Order order = orderMapper.findByOrdernum(ordernum);
		order.setWuliu(wuliu);
		order.setFuwu(fuwu);
		order.setZhiliang(zhiliang);
		orderMapper.commitorder(order);
	}

	@Override
	public List<Order> findByWuliu(String wuliu) {
		// TODO Auto-generated method stub
		return orderMapper.findByWuliu(wuliu);
	}

	@Override
	public Order addOrder(int good_id) {
		// TODO Auto-generated method stub
		Order order = orderMapper.findWithId(good_id);
		orderMapper.addCart(order);
		return order;	}



}
