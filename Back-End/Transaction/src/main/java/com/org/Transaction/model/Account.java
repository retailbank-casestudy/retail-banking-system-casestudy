package com.org.Transaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	private long accountNo;
	
	private String userId;
	private double accountBal;
	private String accountNickName;
	private long creditCardNumber;
	private String accountType;
	public Account() {
		super();
	}
	public Account(long accountNo, String userId, double accountBal, String accountNickName, long creditCardNumber,
			String accountType) {
		super();
		this.accountNo = accountNo;
		this.userId = userId;
		this.accountBal = accountBal;
		this.accountNickName = accountNickName;
		this.creditCardNumber = creditCardNumber;
		this.accountType = accountType;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}
	public String getAccountNickName() {
		return accountNickName;
	}
	public void setAccountNickName(String accountNickName) {
		this.accountNickName = accountNickName;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", userId=" + userId + ", accountBal=" + accountBal
				+ ", accountNickName=" + accountNickName + ", creditCardNumber=" + creditCardNumber + ", accountType="
				+ accountType + "]";
	}
	
}
