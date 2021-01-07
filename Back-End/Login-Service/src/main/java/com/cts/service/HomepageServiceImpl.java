package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cts.entity.Account;
import com.cts.entity.AccountService;
import com.cts.entity.Transaction;
import com.cts.entity.TransactionService;

@Component
public class HomepageServiceImpl implements HomepageService {

	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;
	
	@Override
	public List<Account> getAccounts(long userId) {

		List<Account> accounts = accountService.getLatestAccounts(userId);
		return accounts;
	}

	@Override
	public List<Transaction> getTransactions(long userId) {
		List<Transaction> transactions = transactionService.getTransaction(userId);
		return transactions;
	}

	@Override
	public int getCreditScore(long custId) {
		int score = rest.getForObject("http://CREDITSCORE/score/latest/"+custId, Integer.class);
		return score;
	}

	@Override
	public int getNoOfRewards(long custId) {
		int noOfRewards = rest.getForObject("http://REWARDSAPPLICATION/rewards/getAllRewards/"+custId, Integer.class);
		return noOfRewards;
	}

	
}
