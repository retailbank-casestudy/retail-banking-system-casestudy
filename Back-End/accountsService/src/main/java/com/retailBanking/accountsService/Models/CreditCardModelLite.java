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
public class CreditCardModelLite {

	@Id
	@Column(name = "creditcardnumber")
	private long creditCardNumber;
@Column(name="userid")
private Double userId;


	public CreditCardModelLite() {
		super();
	}

	public CreditCardModelLite(long creditCardNumber, Double userId) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.userId = userId;
	
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	

}
