package org.fkit.service;

import java.util.List;
import org.fkit.domain.Good;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodTest extends BaseJunitTest {
	@Autowired
	private GoodService goodService;
	@Test
	public void test1() {
		int good_id= 2;
		 Good good1=goodService.selectByGoodId(good_id);
		System.out.println(good1);

		}
	@Test
	public void test2() {

		List<Good> good2=goodService.getAll();
		System.out.println(good2);
		}
	
	@Test
	public void test3() {
		String name="1";
		String goodtype="1";
		String price="1";
		String detail="1";
		Integer inventory=2;
		Good good2=goodService.addnewGood(name, goodtype, price, detail, inventory);
		System.out.println(good2);
		}	
}
