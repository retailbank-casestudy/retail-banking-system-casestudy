package com.org.Transaction.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Reference;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	private String userId;
	private double transactionAmount;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate transactionDate;
	private String transactionType;
	private long beneficiaryAccountNumber;
	private long accountNumber;
	
	public Transaction(String userId, double transactionAmount, LocalDate transactionDate,
			String transactionType, long beneficiaryAccountNumber, long accountNumber) {
		super();
		
		this.userId = userId;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.accountNumber = accountNumber;
	}
	public Transaction() {
		super();
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", userId=" + userId + ", transactionAmount="
				+ transactionAmount + ", transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", accountNumber=" + accountNumber + "]";
	}
	
	
	
}
