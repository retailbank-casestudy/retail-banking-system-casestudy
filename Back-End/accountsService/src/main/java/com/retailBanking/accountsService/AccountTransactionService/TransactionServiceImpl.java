package com.retailBanking.accountsService.AccountTransactionService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailBanking.accountsService.Models.Transaction;

import com.retailBanking.accountsService.Repository.TransactionServiceProxy;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionServiceProxy repo;

	@Override
	public List<Transaction> getTransactionByAccount(long accNo) {

		
		return repo.getTransactionByAccount(accNo);
	}

}
