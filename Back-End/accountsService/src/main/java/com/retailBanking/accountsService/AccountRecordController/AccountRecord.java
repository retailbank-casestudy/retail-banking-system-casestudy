package com.retailBanking.accountsService.AccountRecordController;

import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;
import com.retailBanking.accountsService.Models.CreditCardModel;
import com.retailBanking.accountsService.Models.Transaction;

public interface AccountRecord {

	

	List<AccountsModel> getAllAccountsListforType(String type);

	List<AccountsModel> getAllAccountDetails(String type, Double id);

	List<AccountsModel> getAccountDetailsByType();

	AccountsModel getAccountDetailsByAccountNo(String accNo);

	List<CreditCardModel> getCreditCardDetatils();

	List<Transaction> getAccountTransactionData(String accNo);

	List<AccountsModel> getaccountsForHomePage(Double id);

}
