package com.retailBanking.accountsService.AccountRecordService;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailBanking.accountsService.Exceptions.ExceptionImpl;
import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Models.CreditCardModelLite;
import com.retailBanking.accountsService.Repository.CreditCardRepository;
import com.retailBanking.accountsService.Repository.CreditCardRepositoryLite;
import com.retailBanking.accountsService.Repository.AccountRepository;

@Service
public class AccountRecordServiceImpl implements AccountRecordService {
	@Autowired
	AccountRepository repo;

	@Autowired
	CreditCardRepository crepo;
	
	@Autowired
	CreditCardRepositoryLite crepoLite;
	
	@Autowired
	ExceptionImpl exception;

	public List<AccountsModel> getAllAccountsListforType(String type, Double userId) {

		List<AccountsModel> data = repo.findByAccountType(type, userId).stream()
				.sorted((balance1, balance2) -> balance2.getAccountBalance().compareTo(balance1.getAccountBalance()))
				.collect(Collectors.toList());

		return data;
	}

	@Override
	public List<AccountsModel> fetchAllAccountsByDefault(String type, Double id) {

		List<AccountsModel> data = repo.fetchAllAccounts(type, id).stream()
				.sorted((balance1, balance2) -> balance2.getAccountBalance().compareTo(balance1.getAccountBalance()))
				.collect(Collectors.toList());

		return data;

	}

	@Override
	public List<AccountsModel> fetchAllAccountByViewMore(String type, Double id) {
		List<AccountsModel> data = repo.fetchAllAccounts(type, id).stream()
				.sorted((balance1, balance2) -> balance2.getAccountBalance().compareTo(balance1.getAccountBalance()))
				.collect(Collectors.toList());

		return data;
	}

	@Override
	public AccountsModel getAccountDetailsByAccountNo(long accountNo) {
AccountsModel data = repo.getAccountDetailsByAccountNo(accountNo);

		return data;
	}

	

	@Override
	public List<AccountsModel> getAllAccountsList(Double id) {
		List<AccountsModel> list= repo.findByUserId(id);
		
		return list;
	}

	

	@Override
	@Transactional
	public void saveCreditCard(CreditCardModel card) {
	crepo.save(card);
		
	}

	@Override
	public void saveAccountAfterTransaction(AccountsModel account) {
		repo.save(account);
		
	}

	@Override
	public List<CreditCardModelLite> getCreditCardNumbers(Double id) {
	
		return crepoLite.getCreditCardNumbers(id);
	}

	@Override
	public List<CreditCardModel> getCreditCardDetails(Long cardnumber) {
	
		return crepo.getCreditCardDetails(cardnumber);
	}

}
