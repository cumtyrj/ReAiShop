package org.fkit.service;

import java.util.List;
import org.fkit.domain.Order;

public interface OrderService {
	List<Order> getAll();
	Order findgoodWithId(int good_id);
	Order removeOrder(String ordernum);
	void clearOrder();
	void saveOrder(int good_id,String price,String name,String detail,String image,int num,String goodtype,int account,String loginname,String ordernum,String state,int user_id);
	List<Order> findWithOrdernum(String ordernum);
    void updstate(String state,String ordernum);
	Order findByOrdernum(String ordernum);
	List<Order> findByState(String state);
	void commitorder(String wuliu,String zhiliang,String fuwu,String ordernum);
	List<Order> findByWuliu(String wuliu);
	Order addOrder(int good_id);

}
