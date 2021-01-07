package com.retailBanking.accountsService.AccountTransactionService;


import java.util.List;

import com.retailBanking.accountsService.Models.Transaction;

public interface TransactionService {

	List<Transaction> getTransactionByAccount(long accNo);
	
	

}
