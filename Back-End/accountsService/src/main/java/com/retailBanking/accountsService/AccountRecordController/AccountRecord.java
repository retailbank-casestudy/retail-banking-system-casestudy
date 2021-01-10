package com.retailBanking.accountsService.AccountRecordController;

import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Models.CreditCardModelLite;
import com.retailBanking.accountsService.Models.Transaction;

public interface AccountRecord {

	

	List<AccountsModel> getAllAccountsListforType(String type, Double userID);

	List<AccountsModel> getAllAccountDetails(String type, Double id);

	List<AccountsModel> getAccountDetailsByType();

	AccountsModel getAccountDetailsByAccountNo(String accNo);

	

	List<Transaction> getAccountTransactionData(String accNo);

	List<AccountsModel> getaccountsForHomePage(Double id);



List<CreditCardModel> getCreditCardDetails(String credno);

	List<CreditCardModelLite> getCreditCardNumbers(double id);

	List<Transaction> getCreditCardTransactionDetails(String credno);

	List<Transaction> fallbackForGetTransactionByAccount(String no);

	List<AccountsModel> getaccountsForTransactions(String id);

//	CreditCardModel getCreditCardDetails(long credno);

	

}
