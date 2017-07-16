package org.fkit.domain;

import java.util.List;

public class Order {
	private int id;
	private List<Good> good;
	private int good_id;
	private String name;			// 书名
	private String price;			// 价格
	private String detail;
	private String image;			// 封面图片
	private String goodtype;
	private int num;
	private String account;
	private String ordernum;
	private String state;
	private String wuliu;
	private String zhiliang;
	private String fuwu;
	private int user_id;
	public int getId() {
		return id;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGoodtype() {
		return goodtype;
	}
	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWuliu() {
		return wuliu;
	}
	public void setWuliu(String wuliu) {
		this.wuliu = wuliu;
	}
	public String getZhiliang() {
		return zhiliang;
	}
	public void setZhiliang(String zhiliang) {
		this.zhiliang = zhiliang;
	}
	public String getFuwu() {
		return fuwu;
	}
	public void setFuwu(String fuwu) {
		this.fuwu = fuwu;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
