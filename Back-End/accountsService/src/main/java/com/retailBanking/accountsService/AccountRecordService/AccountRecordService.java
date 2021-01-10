package com.retailBanking.accountsService.AccountRecordService;

import java.math.BigInteger;
import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Models.CreditCardModelLite;

public interface AccountRecordService {

	 List<AccountsModel> getAllAccountsListforType(String type, Double userId);

	

	List<AccountsModel> fetchAllAccountsByDefault(String type, Double id);



	List<AccountsModel> fetchAllAccountByViewMore(String type, Double id);



	AccountsModel getAccountDetailsByAccountNo(long accountNo);



	

	List<AccountsModel> getAllAccountsList(Double id);



	



	void saveCreditCard(CreditCardModel card);



	void saveAccountAfterTransaction(AccountsModel account);



	List<CreditCardModelLite> getCreditCardNumbers(Double id);



	List<CreditCardModel> getCreditCardDetails(Long cardnumber);



	



	

		
}
