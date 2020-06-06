package com.core.java.mobilebankingcore.dto;

import java.io.Serializable;

public class FundTransferDTO implements Serializable {

	private static final long serialVersionUID = -3337855405798715L;
	
	private String userName;
	private String password;
	private Integer amount;
	private Integer accountNo;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	
	
}
