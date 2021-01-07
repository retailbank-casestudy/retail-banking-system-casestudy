package com.cts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Account;
import com.cts.entity.Transaction;
import com.cts.service.HomepageServiceImpl;

@RestController
@CrossOrigin("*")
public class HomepageController {
	
	@Autowired
	private HomepageServiceImpl service;
	
	
//	@GetMapping("/{userId}")
//	public Map<String,Object> getHomepage(@PathVariable long userId){
//		Map<String,Object> map = new HashMap<>();
//		map.put("accounts", service.getAccounts(userId));//returns top 3 accounts
//		map.put("transactions",service.getTransactions(userId));//returns top 5 transactions
//		map.put("creditScore", service.getCreditScore(userId));//returns credit Score
//		map.put("noOfRewards", service.getNoOfRewards(userId));//return no of rewards
//
//		return map;
//	}

	@GetMapping("accounts/{userId}")
	public List<Account> getTop3Accounts(@PathVariable long userId){
		
		List<Account> accounts = service.getAccounts(userId);
		return accounts;
	}
	@GetMapping("transactions/{userId}")
	public List<Transaction> getTop5Transactions(@PathVariable String userId){
		List<Transaction> transactions = service.getTransactions(userId);
		return transactions;
	}
	
	@GetMapping("creditscore/{userId}")
	public int getCreditScore(@PathVariable long userId) {
		return service.getCreditScore(userId);
	}
	@GetMapping("rewards/{userId}")
	public int getNoOfRewards(@PathVariable long userId) {
		return service.getNoOfRewards(userId);
	}
	
	
	
}
