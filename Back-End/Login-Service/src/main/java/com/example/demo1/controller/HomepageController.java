package com.example.demo1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Account;
import com.cts.entity.Transaction;
import com.cts.service.HomepageServiceImpl;
import com.example.demo1.service.MyUserDetails;

@RestController
@CrossOrigin(origins = "*")
public class HomepageController {
	
	public int idd;
	
	@Autowired
	private HomepageServiceImpl service;
	
	@Autowired
	private MyUserDetails mvd;
	
	@GetMapping("/login")
	public int homepage() {

		MyUserDetails mv = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 idd = mv.getId();
		return idd;
		
	}
	
	@GetMapping("/homee/{idd}")
	public int afterLogin(@PathVariable("idd")String idd) {
		int id=Integer.parseInt(idd);
		return id;
	}
	
	@GetMapping("/{idd}")
	public Map<String,Object> getHomepage(@PathVariable("idd") long idd){
		Map<String,Object> map = new HashMap<>();
		map.put("accounts", service.getAccounts(idd));//returns top 3 accounts
		map.put("transactions",service.getTransactions(idd));//returns top 5 transactions
		map.put("creditScore", service.getCreditScore(idd));//returns credit Score
		map.put("noOfRewards", service.getNoOfRewards(idd));//return no of rewards

		return map;
	}

	@GetMapping("accounts/{idd}")
	public List<Account> getTop3Accounts(@PathVariable("idd") long idd){
		
		List<Account> accounts = service.getAccounts(idd);
		return accounts;
	}
	@GetMapping("transactions/{idd}")
	public List<Transaction> getTop5Transactions(@PathVariable("idd") long idd){
		List<Transaction> transactions = service.getTransactions(idd);
		return transactions;
	}
	
	@GetMapping("creditscore/{idd}")
	public int getCreditScore(@PathVariable("idd") long idd) {
		return service.getCreditScore(idd);
	}
	@GetMapping("rewards/{idd}")
	public int getNoOfRewards(@PathVariable("idd") long idd) {
		return service.getNoOfRewards(idd);
	}
	
	
	
}
