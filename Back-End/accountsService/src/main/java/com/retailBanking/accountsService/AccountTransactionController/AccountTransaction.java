package com.retailBanking.accountsService.AccountTransactionController;

import java.math.BigInteger;
import java.util.List;

import com.retailBanking.accountsService.Models.Transaction;

public interface AccountTransaction {

	List<Transaction> getTransactionByAccount(long accountNo) throws Exception;

}
