package com.org.Transaction.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.Transaction.dao.TransactionDao;
import com.org.Transaction.exception.AccountNotExistsException;
import com.org.Transaction.exception.BeneficiaryNotExistsException;
import com.org.Transaction.exception.CreditLimitExceededException;
import com.org.Transaction.exception.InsufficientBalanceException;
import com.org.Transaction.model.Account;
import com.org.Transaction.model.AccountList;
import com.org.Transaction.model.AccountsModel;
import com.org.Transaction.model.Beneficiary;
import com.org.Transaction.model.CreditCard;
import com.org.Transaction.model.CreditCardModel;
import com.org.Transaction.model.Transaction;

import net.bytebuddy.asm.Advice.Local;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDao dao;

	@Autowired
	private RestTemplate restTemplate;

	public List<Transaction> getTransactionsWithFilters(LocalDate startDate,
			LocalDate endDate) {
		List<Transaction> list = dao.getTransactionsByDate(startDate,endDate);
		
		
		return list;
	}

	public List<Transaction> getAllTransactions(String userId) {
		return dao.getAllTransactions().stream().filter(transaction -> transaction.getUserId().equals(userId)).collect(Collectors.toList());
	}

	public void addTransaction(String userId,long accountNo, long beneficiaryAccountNumber, double amount, String transactionType,List<AccountsModel> list) throws CreditLimitExceededException, BeneficiaryNotExistsException, AccountNotExistsException, InsufficientBalanceException {
		// get all accounts for the user Id from Accounts
		// Account
		// account=rest.getForObject("http://ACCOUNTS-SERVICE/.....",Account.class);

		List<AccountsModel> accounts = list;
		
		//AccountList list = restTemplate.getForObject("http://accountsService/accountsForTransactionService/?userid="+userId, AccountList.class);
		System.out.println("data came here");
		//accounts = list.getAccounts();
		System.out.println("data came here");
		Transaction transaction=null;
		int flag=0;
		
			for (AccountsModel account : accounts) {
			if (account.getAccountNo() == accountNo ) {
				flag=1;
				//BigInteger k = BigDecimal.valueOf(amount).toBigInteger();
				if(beneficiaryExists(beneficiaryAccountNumber)) {
				if(transactionType.equals("CREDITCARD")) {
					System.out.println("202");
						CreditCardModel card = restTemplate.getForObject("http://accountsService/getCreditCard/?accno="+account.getAccountNo(), CreditCardModel.class);
						System.out.println(card.getCreditCardNumber());
						if(amount <= card.getAvaliableLimit().doubleValue()) {
							
							
							BigInteger k = BigDecimal.valueOf(card.getAvaliableLimit().doubleValue()-amount).toBigInteger();
							card.setAvaliableLimit(k);
							
							transaction = new Transaction(userId,amount, LocalDate.now(), transactionType,beneficiaryAccountNumber, accountNo);
							restTemplate.postForObject("http://accountsService/saveCreditCardDetailsAfterTransaction", card, CreditCard.class);
							dao.saveTransaction(transaction);
							
						}
						else {
							//credit limit exceeded
							throw new CreditLimitExceededException("Credit Limit Exceeded");
						}
					}
						
					else if(account.getAccountBalance().doubleValue()>=amount){
						BigInteger k = BigDecimal.valueOf(account.getAccountBalance().doubleValue()-amount).toBigInteger();
						account.setAccountBalance(k);
						Double id = Double.parseDouble(userId);
						account.setUserid(id);
						
						restTemplate.postForObject("http://accountsService/saveAccountAfterTransaction", account, AccountsModel.class);
						transaction = new Transaction( userId,amount, LocalDate.now(), transactionType,beneficiaryAccountNumber, accountNo);
						dao.saveTransaction(transaction);
					}
					else {
						
						throw new InsufficientBalanceException("Insufficient Balance");
					}
				}
				else{
					throw new BeneficiaryNotExistsException("Beneficiary does not exist");
				}

			}
			

		}
		if(flag==0) {
			throw new AccountNotExistsException("Account Does Not exist");
		}
		else {
			System.out.println(transaction);
		}
	}

	public boolean beneficiaryExists(long beneficiaryAccountNumber) {
		if (dao.getBeneficiary(beneficiaryAccountNumber) != 0) {
			return true;
		}
		return false;
	}

	public List<Transaction> getAllTransactionsUsingAccountNumber(long accountNumber) {
		return dao.getAllTransactions().stream().filter(t -> t.getAccountNumber() == accountNumber)
				.collect(Collectors.toList());
	}
	
	
	public List<Transaction> getLastFive(String userId){
		return dao.getAllTransactions().stream().filter(t -> t.getUserId().equals(userId))
				.sorted(Comparator.comparing(Transaction::getTransactionDate).reversed()).limit(5)
				.collect(Collectors.toList());
	}

	public List<Transaction> getLastFiveTransactions(long accountNumber) {
		return dao.getAllTransactions().stream().filter(t -> t.getAccountNumber() == accountNumber)
				.sorted(Comparator.comparing(Transaction::getTransactionDate).reversed()).limit(5)
				.collect(Collectors.toList());

	}

	@Override
	public List<Transaction> getTransactionsWithFiltersType(String type) {
		
		return dao.getTransactionsWithFiltersType(type);
	}

	@Override
	public List<Transaction> getTransactionByAccount(long accNo) {
		
		return dao.getTransactionByAccount(accNo);
	}

//	public void getCreditCard() {
//		AccountList list = restTemplate.getForObject("http://DUMMY-CLIENT/getList", AccountList.class);
//		System.out.println(list.getAccounts());
//		CreditCard card = restTemplate.getForObject("http://DUMMY-CLIENT/getCreditCard", CreditCard.class);
//	}
	

}
