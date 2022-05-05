package com.ssafy.web.vo;

public class ShinHanVO {
	private String acc,cust_name;
	private long amount;
	
	
	
	public ShinHanVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShinHanVO(String acc, String cust_name, long amount) {
		super();
		this.acc = acc;
		this.cust_name = cust_name;
		this.amount = amount;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
}

