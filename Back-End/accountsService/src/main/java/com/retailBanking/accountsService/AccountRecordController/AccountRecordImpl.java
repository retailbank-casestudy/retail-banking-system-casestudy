package com.retailBanking.accountsService.AccountRecordController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.retailBanking.accountsService.AccountRecordService.AccountRecordService;
import com.retailBanking.accountsService.AccountTransactionController.AccountTransaction;
import com.retailBanking.accountsService.BusinessLogic.First5Accounts;
import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Models.CreditCardModelLite;
import com.retailBanking.accountsService.Models.Transaction;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountRecordImpl implements AccountRecord {

	Double id;

	String type;

	long accountNo;

	List<AccountsModel> data = new ArrayList<AccountsModel>();

	@Autowired
	AccountRecordService service;

	@Autowired
	First5Accounts firstFiveAccount;

	@Autowired
	AccountTransaction accountTransaction;
	
	
	@Override
	@GetMapping("/accountsForHomePage")
	public List<AccountsModel> getaccountsForHomePage(@RequestParam(name = "id") Double id) {
		this.id = id;
		this.type = "savings";
		List<AccountsModel> getThreeAccounts =getAllAccountDetails(type, id).stream().limit(3).collect(Collectors.toList());
		return getThreeAccounts;
	}
@Override
	@GetMapping(value = "/accountsForTransactionService",produces =MediaType.APPLICATION_JSON_VALUE)
	public List<AccountsModel> getaccountsForTransactions(@RequestParam("userid")String id) {
		System.out.println("in accounts");
		
		Double userId = Double.parseDouble(id);
		
		List<AccountsModel> getAccounts =getAllAccountDetailsForTransaction(userId);
		return getAccounts;
	}

	
	
	private List<AccountsModel> getAllAccountDetailsForTransaction(Double id) {
			List<AccountsModel> data = service.getAllAccountsList(id);
			return data;
	}

	@Override
	@GetMapping("/defaultAccount")
	public List<AccountsModel> getAllAccountDetails(@RequestParam(name = "type") String type,
			@RequestParam(name = "id") Double id) {
		System.out.println(id);
		this.id = id;
		this.type = type;
		List<AccountsModel> accountDetailslist = service.fetchAllAccountsByDefault(type, id);
		data = accountDetailslist;

		return firstFiveAccount.firstFiveAccounts(accountDetailslist);
	}

	@Override
	@GetMapping("/viewMore")
	public List<AccountsModel> getAccountDetailsByType() {
		System.out.println(type + "-"+id);
		List<AccountsModel> accountDetailsByTypeList = service.fetchAllAccountByViewMore(type, id);
		return accountDetailsByTypeList;
	}

	@Override
	public List<AccountsModel> getAllAccountsListforType( String acctype , Double id) {

		
		this.type=acctype;
		this.id=id;
		System.out.println(type+id);
		List<AccountsModel> data = service.getAllAccountsListforType(type, id);

		return firstFiveAccount.firstFiveAccounts(data);

	}

	@Override
	@GetMapping("/getSpecificAccount")
	public AccountsModel getAccountDetailsByAccountNo(@RequestParam(name = "accno") String accNo ) {
		System.out.println("here");		
	  accountNo = Long.parseLong(accNo);
	  AccountsModel accountDetailsByAccountNoList = service.getAccountDetailsByAccountNo(accountNo);
	  System.out.println("here");		
	  return accountDetailsByAccountNoList;
	
	
	}

	@Override
	@GetMapping("/getCreditCardNumber")//using user id
	public List<CreditCardModelLite> getCreditCardNumbers(@RequestParam("userID") double id) {
        this.id=id;
		System.out.println(this.id);
		List<CreditCardModelLite> creditCardData = new ArrayList<CreditCardModelLite>();
		try {
			creditCardData = service.getCreditCardNumbers(this.id);
		} catch (Exception e) {
			// return "Please go to bank and apply for Credit Card";
			System.out.println("Please go to bank and apply for Credit Card");
		}
		return creditCardData;
	}
	
	@Override
	@GetMapping("/getCreditCardDetails")//using cardno
public List<CreditCardModel> getCreditCardDetails(@RequestParam("credno") String credno) {
        
		System.out.println(credno);
		Long cardnumber = Long.parseLong(credno);
		List<CreditCardModel> creditCardData = new ArrayList<CreditCardModel>();
		try {
			creditCardData = service.getCreditCardDetails(cardnumber);
		} catch (Exception e) {
			// return "Please go to bank and apply for Credit Card";
			System.out.println("Please go to bank and apply for Credit Card");
		}
		System.out.println(creditCardData);
		return creditCardData;
	}
	@Override
	@GetMapping("/getCreditCardTransactionDetails")//using cardno
public List<Transaction> getCreditCardTransactionDetails(@RequestParam("credno") String credno) {
        System.out.println(credno+"in traxn details");
		long accountNo = Long.parseLong(credno);
		List<Transaction> trxndata = new ArrayList<Transaction>();
		try {
			trxndata= accountTransaction.getTransactionByAccount(accountNo);
		} catch (Exception e) {
		
			 return trxndata;
			
		//	System.out.println("no data available , if problem presists please visit near by bank branch");
		}
		
		
		
		return trxndata.stream().sorted((x, y) -> y.getTransactionDate().compareTo(x.getTransactionDate())).limit(2).collect(Collectors.toList());
		
	}
	
	

	@Override
	@GetMapping(value = "/getAccountTransactionData", produces = { MediaType.APPLICATION_JSON_VALUE })
	@HystrixCommand(fallbackMethod = "fallbackForGetTransactionByAccount", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public List<Transaction> getAccountTransactionData(@RequestParam("accNo") String accNo) {
		System.out.println(accNo+"traxn Data");
		long accountNo = Long.parseLong(accNo);
		List<Transaction> trxndata = new ArrayList<Transaction>();
		try {
			trxndata= accountTransaction.getTransactionByAccount(accountNo);
		} catch (Exception e) {
		
			 return trxndata;
			
		//	System.out.println("no data available , if problem presists please visit near by bank branch");
		}
		
		return trxndata.stream().sorted((x, y) -> y.getTransactionDate().compareTo(x.getTransactionDate())).limit(2).collect(Collectors.toList());
		
	}
	
	@Override
	@GetMapping("account/serviceDown")
    public List<Transaction> fallbackForGetTransactionByAccount(String no){
        System.out.println("fallbackForGetTransactionByAccount() is called");
        List<Transaction> list=new ArrayList<>();
       
        return list;
       
//        return "Service down, try after sometime!!!";
    }
	/*
	@PostMapping(value = "/saveCreditCardDetailsAfterTransaction" ,consumes = MediaType.APPLICATION_JSON_VALUE)
public CreditCardModel saveCreditCard(@RequestBody CreditCardModel card) {
        
		System.out.println(card);
		
		service.saveCreditCard(card);
		
		return null;
	}
	
	@PostMapping(value = "/saveAccountAfterTransaction" ,consumes = MediaType.APPLICATION_JSON_VALUE)
public AccountsModel saveAccountAfterTransaction(@RequestBody AccountsModel account) {
        
		
		
		service.saveAccountAfterTransaction(account);
		
		return null;
	}
	
	*/


}
