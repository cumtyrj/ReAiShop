package org.fkit.domain;

import java.util.List;

public class Cart {
	private Integer id;
	private Integer user_id;
	private String name;			// 书名
	private String price;			// 价格
	private String detail;
	private String image;			// 封面图片
	private Integer num;
	private List<Good> good;
	private int good_id;
	private String goodtype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ",good_id=" + good_id + ", name=" + name + ","
				+ "price=" + price + ",detail="+ detail +" ,image=" + image + ", num=" + num + ",user_id=" + user_id + ", goodtype=" + goodtype + "]";
	}

	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public List<Good> getGood() {
		return good;
	}
	public void setGood(List<Good> good) {
		this.good = good;
	}
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getGoodtype() {
		return goodtype;
	}
	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}
	
}

