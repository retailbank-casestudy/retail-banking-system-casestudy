package com.retailBanking.accountsService.AccountTransactionController;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.retailBanking.accountsService.AccountTransactionService.TransactionService;
import com.retailBanking.accountsService.Exceptions.Exceptions;
import com.retailBanking.accountsService.Models.Transaction;
import com.retailBanking.accountsService.Repository.TransactionServiceProxy;

@RestController
public class AccountTransactionImpl implements AccountTransaction {
	@Autowired
	TransactionServiceProxy service;
	
	@Autowired
	Exceptions exception;

	@Override
	public List<Transaction> getTransactionByAccount(long accNo) throws Exception {
		List<Transaction> transaction = service.getTransactionByAccount(accNo);
		if (transaction.isEmpty())
			exception.noTransactionFound();
		
		return transaction;
	}

}
