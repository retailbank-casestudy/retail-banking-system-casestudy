package com.cts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.entity.Account;
import com.cts.entity.Transaction;

@Service
public interface HomepageService {

	List<Account> getAccounts(long custId);
	
	List<Transaction> getTransactions(long custId);
	
	int getCreditScore(long custId);
	
	int getNoOfRewards(long custId); 
}
