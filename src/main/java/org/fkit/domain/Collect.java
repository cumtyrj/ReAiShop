package org.fkit.domain;

import java.util.List;

public class Collect {
	private int id;
	private List<Good> good;
	private int good_id;
	private int user_id;
	private String name;			// 书名
	private String price;			// 价格
	private String detail;
	private String image;			// 封面图片
	private String goodtype;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "collect [id=" + id + ", good=" + good + ", good_id=" + good_id + ", user_id=" + user_id + "]";
	}
	public void setId(int id) {
		this.id = id;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGoodtype() {
		return goodtype;
	}
	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}
	

}
