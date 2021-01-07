package com.cts.entity;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	private long transactionId;
	private String userId;
	private double transactionAmount;
	private LocalDate transactionDate;
	private String transactionType;
	private long beneficiaryAccountNumber;
	private long accountNumber;	

	
}
