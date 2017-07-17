package org.fkit.service.impl;

import java.util.List;

import org.fkit.domain.Good;
import org.fkit.mapper.GoodMapper;
import org.fkit.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("goodService")
public class GoodServiceImpl implements GoodService {
	@Autowired
	private GoodMapper goodMapper;
	@Override
	public List<Good> chairgetAll(String goodtype) {
		// TODO Auto-generated method stub
		return goodMapper.chairfindAll(goodtype);
	}
	@Override
	public List<Good> bookcasegetAll(String goodtype) {
		// TODO Auto-generated method stub
		return goodMapper.bookcasefindAll(goodtype);
	}
	@Override
	public List<Good> vesselgetAll(String goodtype) {
		// TODO Auto-generated method stub
		return goodMapper.vesselfindAll(goodtype);
	}
	@Override
	public List<Good> toolgetAll(String goodtype) {
		// TODO Auto-generated method stub
		return goodMapper.toolfindAll(goodtype);
	}
	@Override
	public Good selectByGoodId(int good_id) {
		// TODO Auto-generated method stub
		return goodMapper.selectByGoodId(good_id);
	}
	@Override
	public List<Good> getAll() {
		// TODO Auto-generated method stub
		return goodMapper.findAll();
	}
	@Override
	public  Good addnewGood(String name, String goodtype, String price, String detail, Integer inventory) {
		// TODO Auto-generated method stub
		Good good=new Good();
		good.setDetail(detail);
		good.setGoodtype(goodtype);
		good.setInventory(inventory);
		good.setName(name);
		good.setPrice(price);
		goodMapper.addnewGood(name, detail, inventory, goodtype, price);
		return good;
	}
	@Override
	public Good mngremoveGood(int good_id) {
		// TODO Auto-generated method stub
		Good good = goodMapper.selectByGoodId(good_id);
		goodMapper.mngremoveGood(good);
		return good;
	}
	@Override
	public Good addimage(String image) {
		// TODO Auto-generated method stub
		Good good=new Good();
		good.setImage1(image);
		goodMapper.addimage(image);
		return good;
	}
/*	@Override
	public Good addSales(int good_id) {
		// TODO Auto-generated method stub
		Good good = goodMapper.selectByGoodId(good_id);
		final int i = 1;
		good.setSales(i);
		goodMapper.reduceInventory(good);
		return good;
	}
	@Override
	public Good reduceInventory(int good_id) {
		// TODO Auto-generated method stub
		Good good = goodMapper.selectByGoodId(good_id);
		final int i = 1;
		good.setInventory(i);
		goodMapper.reduceInventory(good);
		return good;
	}
*/
	@Override
	public Good mngupdgood(int good_id,String name, String goodtype, String price, String detail, Integer inventory) {
		// TODO Auto-generated method stub

		Good good=goodMapper.selectByGoodId(good_id);
		good.setDetail(detail);
		good.setGoodtype(goodtype);
		good.setInventory(inventory);
		good.setName(name);
		good.setPrice(price);
		goodMapper.mngupdGood(good);
		return good;
	}
	@Override
	public Good addSales(int good_id,int sales) {
		// TODO Auto-generated method stub
		Good good = goodMapper.selectByGoodId(good_id);
		good.setSales(sales);
		goodMapper.addSales(good);
		return good;
	}
	@Override
	public Good reduceInventory(int good_id, int inventory) {
		// TODO Auto-generated method stub
		Good good = goodMapper.selectByGoodId(good_id);
		good.setInventory(inventory);
		goodMapper.reduceInventory(good);
		return good;
	}

}
