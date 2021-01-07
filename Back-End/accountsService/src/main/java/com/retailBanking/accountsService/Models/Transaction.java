package com.retailBanking.accountsService.Models;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction {
	
	private double transactionId;
	   private double transactionAmount;
	   
	   @JsonFormat(pattern="dd-MM-yyyy")
	   private LocalDate transactionDate;

	public double getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Transaction(double transactionId, double transactionAmount, LocalDate transactionDate) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + "]";
	}

	
	
	
	   
	   
		

}