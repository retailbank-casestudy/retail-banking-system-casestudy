package com.org.Transaction.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonValue;
import com.org.Transaction.exception.AccountNotExistsException;
import com.org.Transaction.exception.BeneficiaryNotExistsException;
import com.org.Transaction.exception.CreditLimitExceededException;
import com.org.Transaction.exception.InsufficientBalanceException;
import com.org.Transaction.model.AccountsModel;
import com.org.Transaction.model.CreditCard;
import com.org.Transaction.model.Transaction;
import com.org.Transaction.repository.accountMicroserviceProxy;
import com.org.Transaction.service.TransactionService;
import com.org.Transaction.service.TransactionServiceImpl;

@RestController
//@RequestMapping("{userId}/transaction")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
	String userId ;
	@Autowired
	private TransactionService service;
	
	@Autowired
	accountMicroserviceProxy proxy;

	@GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addTransaction( @RequestParam("accountNo") long accountNo,@RequestParam("beneficiaryAccountNumber") long beneficiaryAccountNumber, @RequestParam("amount") double amount,@RequestParam("transactionType") String transactionType) {	
		System.out.println("working");
		List<AccountsModel> list = proxy.getaccountsForTransactions(userId);
		ResponseEntity<Object> response = null;
		try {
			service.addTransaction( userId,accountNo,beneficiaryAccountNumber,amount,transactionType,list);
			response = ResponseEntity.status(200).body("Transaction Successful");
		} catch (CreditLimitExceededException | BeneficiaryNotExistsException | AccountNotExistsException | InsufficientBalanceException e) {
			//return response = ResponseEntity.status(400).body("error");
			return (e.getMessage());
		}
		return "success";
	}

/*	@GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountsModel> addTransactiondata( @RequestParam("accountNo") long accountNo,@RequestParam("beneficiaryAccountNumber") long beneficiaryAccountNumber, @RequestParam("amount") double amount,@RequestParam("transactionType") String transactionType) {	
		System.out.println("working");
		List<AccountsModel> list = proxy.getaccountsForTransactions(userId);
		System.out.println(list);
		return list;
	}
*/
	
//	@RequestMapping(value = "/filtersByType", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
//	public List<Transaction> getTransactionsWithFiltersType(@RequestParam("transactionType") String type){
//		List<Transaction> list = service.getTransactionsWithFiltersType(type);
//		return list;
//	}
//	
//	@RequestMapping(value = "/filtersByDate", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
//	public List<Transaction> getTransactionsWithFilters( @RequestParam("startdate") String startDate,@RequestParam("enddate") String endDate){
//		LocalDate sDate = LocalDate.parse(startDate);
//		LocalDate eDate = LocalDate.parse(endDate);
//		
//		List<Transaction> list = service.getTransactionsWithFilters(sDate, eDate);
//		return list;
//	}
	
	@GetMapping(value= "/getall/{accountNo}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getList(@PathVariable("accountNo") long accountNo){
		return service.getAllTransactionsUsingAccountNumber(accountNo);
	}
	@GetMapping(value="/getfive/{accountNo}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getLastFive(@PathVariable("accountNo") long accountNo) {
		return service.getLastFiveTransactions(accountNo);
	}
	
	@GetMapping(value = "/lastThreeMonths", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> lastThreeMonths(@RequestParam("userId") String userId){
		this.userId = userId;
		System.out.println("here");
		return service.getLastThreeMonthsTransactions(userId);
	}
	////for account -Service
	@GetMapping(value="account/{accountNo}",produces = { MediaType.APPLICATION_JSON_VALUE})
	List<Transaction> getTransactionByAccount(@PathVariable("accountNo") long accNo){
		return service.getTransactionByAccount(accNo);
	};
	@GetMapping(value="/accountlist")
	public List<Long> getAccountList(@RequestParam("userId") String userId){
		System.out.println("Roshan");
		List<AccountsModel> accounts= proxy.getaccountsForTransactions(userId);
		return service.getAccountList(accounts) ;
	}
	
	@GetMapping("/filter")
	public List<Transaction> getTransactionsWithAllFilters(@RequestParam("userId") String userId, @RequestParam("accNo") @Nullable String accNo, @RequestParam("transactionType") @Nullable String transactionType, @RequestParam("startDate") @Nullable String startDate,@RequestParam("endDate") @Nullable String endDate){
		System.out.println("Start Date : "+startDate);
		return service.getFilters(userId, accNo, transactionType, startDate, endDate);

	}
//	@GetMapping(value = "/showCreditCard")
//	public CreditCard getCreditCard() {
//		return service.getCreditCard();
//	}
	
	@GetMapping(value = "/lastfive", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> lastFive(@RequestParam("userId") String userId){
		this.userId = userId;
		System.out.println("here");
		return service.getLastFive(userId).stream().limit(5).collect(Collectors.toList());
	}
	
	


}
