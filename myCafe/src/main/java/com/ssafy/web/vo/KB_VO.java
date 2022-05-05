package com.ssafy.web.vo;

public class KB_VO {
	
	private String accountNo,name,bank;
	private long balance, remitAmount;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getRemitAmount() {
		return remitAmount;
	}
	public void setRemitAmount(long remitAmount) {
		this.remitAmount = remitAmount;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
}

