package org.fkit.service.impl;

import java.util.List;

import org.fkit.domain.Cart;
import org.fkit.domain.Collect;
import org.fkit.mapper.CollectMapper;
import org.fkit.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("collectService")
public class CollectServiceImpl implements CollectService{
	@Autowired
	private CollectMapper collectMapper;
	@Override
	public List<Collect> getAll() {
		// TODO Auto-generated method stub
		return collectMapper.findAll();
	}

	@Override
	public Collect removeCollect(int good_id) {
		// TODO Auto-generated method stub
		Collect collect = collectMapper.findWithId(good_id);
		collectMapper.removeCollect(collect);
		return collect;
	}

	@Override
	public void clearCollect() {
		// TODO Auto-generated method stub
		collectMapper.clearCollect();
	}

	@Override
	public Collect findgoodWithId(int good_id) {
		// TODO Auto-generated method stub
		return collectMapper.findWithId(good_id);
	}


	@Override
	public void saveCollect(int good_id, String price, String name, String detail, String image, String goodtype,int user_id) {
		// TODO Auto-generated method stub
		Collect collect = new Collect();
		collect.setGood_id(good_id);
		collectMapper.saveCollect(good_id, price, name, detail, image, goodtype,user_id);
	}

	@Override
	public List<Collect> getCollectByUserid(int user_id) {
		// TODO Auto-generated method stub
		Collect collect =new Collect();
		collect.getUser_id();
		return collectMapper.getCollectByUserid(user_id);
	}


}
