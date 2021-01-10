package com.org.Transaction.service;

import java.time.LocalDate;
import java.util.List;

import com.org.Transaction.exception.AccountNotExistsException;
import com.org.Transaction.exception.BeneficiaryNotExistsException;
import com.org.Transaction.exception.CreditLimitExceededException;
import com.org.Transaction.exception.InsufficientBalanceException;
import com.org.Transaction.model.AccountsModel;
import com.org.Transaction.model.Transaction;

public interface TransactionService {
	public List<Transaction> getTransactionsWithFilters(LocalDate date, LocalDate startDate);
	public List<Transaction> getAllTransactions(String userId);
	public void addTransaction(String userId, long accountNo, long beneficiaryAccountNumber, double amount, String transactionType, List<AccountsModel> list) throws CreditLimitExceededException, BeneficiaryNotExistsException, AccountNotExistsException, InsufficientBalanceException;
	public boolean beneficiaryExists(long beneficiaryAccountNumber);
	public List<Transaction> getAllTransactionsUsingAccountNumber(long accountNumber);
	public List<Transaction> getLastFive(String userId);
	public List<Transaction> getLastFiveTransactions(long accountNumber);
	public List<Transaction> getTransactionsWithFiltersType(String type);
	public List<Transaction> getTransactionByAccount(long accNo);
	public List<Long> getAccountList(List<AccountsModel> accounts);
	List<Transaction> getFilters(String userId, String accNo, String transactionType, String startDate, String endDate);
	public List<Transaction> getLastThreeMonthsTransactions(String userId);
}
