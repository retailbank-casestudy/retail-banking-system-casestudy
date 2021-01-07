package com.retailBanking.accountsService.Models;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "creditcard")
public class CreditCardModel {

	@Id
	@Column(name = "creditcardnumber")
	private long creditCardNumber;

	@Column(name = "accountno")
	private long accountNo;

	@Column(name = "creditlimit")
	private BigInteger creditLimit;

	@Column(name = " availablelimit")
	private BigInteger avaliableLimit;

	@Column(name = "paymentduedate")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate paymentDueDate;

	@Column(name = "minimumpayment")
	private BigInteger minimumPayment;

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public BigInteger getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigInteger creditLimit) {
		this.creditLimit = creditLimit;
	}

	public BigInteger getAvaliableLimit() {
		return avaliableLimit;
	}

	public void setAvaliableLimit(BigInteger avaliableLimit) {
		this.avaliableLimit = avaliableLimit;
	}

	public BigInteger getMinimumPayment() {
		return minimumPayment;
	}

	public void setMinimumPayment(BigInteger minimumPayment) {
		this.minimumPayment = minimumPayment;
	}

	public LocalDate getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(LocalDate paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public CreditCardModel() {
		super();
	}

	public CreditCardModel(long creditCardNumber, long accountNo, BigInteger creditLimit,
			BigInteger avaliableLimit, LocalDate paymentDueDate, BigInteger minimumPayment) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.accountNo = accountNo;
		this.creditLimit = creditLimit;
		this.avaliableLimit = avaliableLimit;
		this.paymentDueDate = paymentDueDate;
		this.minimumPayment = minimumPayment;
	}

}
