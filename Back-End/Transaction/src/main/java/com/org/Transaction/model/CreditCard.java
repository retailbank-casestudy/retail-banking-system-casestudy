package com.org.Transaction.model;




public class CreditCard {
	
	private long accountNumber;
	private long creditCardNumber;
	private double creditLimit;
	private double availableBalance;
	private String paymentDueDate;
	public CreditCard() {
		super();
	}
	public CreditCard(long accountNumber, long creditCardNumber, double creditLimit, double availableBalance,
			String paymentDueDate) {
		super();
		this.accountNumber = accountNumber;
		this.creditCardNumber = creditCardNumber;
		this.creditLimit = creditLimit;
		this.availableBalance = availableBalance;
		this.paymentDueDate = paymentDueDate;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	@Override
	public String toString() {
		return "CreditCard [accountNumber=" + accountNumber + ", creditCardNumber=" + creditCardNumber
				+ ", creditLimit=" + creditLimit + ", availableBalance=" + availableBalance + ", paymentDueDate="
				+ paymentDueDate + "]";
	}

	
	
}
