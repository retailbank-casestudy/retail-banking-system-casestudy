package com.org.Transaction.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


public class AccountsModel {


	private Double userid;

	
	public Double getUserid() {
		return userid;
	}

	public void setUserid(Double userid) {
		this.userid = userid;
	}

	private long accountNo;

	
	private String accountType;

	
	private String accountNickName;

	
	private BigInteger accountBalance;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNickName() {
		return accountNickName;
	}

	public void setAccountNickName(String accountNickName) {
		this.accountNickName = accountNickName;
	}

	public BigInteger getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigInteger accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountsModel() {
		super();
	}

	public AccountsModel(Double userid, long accountNo, String accountType, String accountNickName,
			BigInteger accountBalance) {
		super();
		this.userid = userid;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountNickName = accountNickName;
		this.accountBalance = accountBalance;
	}

	/*
	 * @OneToMany(targetEntity = CreditCardModel.class, mappedBy = "accountNo")
	 * private List<CreditCardModel> cardModel;
	 * 
	 * public List<CreditCardModel> getCardModel() { return cardModel; }
	 * 
	 * public void setCardModel(List<CreditCardModel> cardModel) { this.cardModel =
	 * cardModel; }
	 */

	

}
