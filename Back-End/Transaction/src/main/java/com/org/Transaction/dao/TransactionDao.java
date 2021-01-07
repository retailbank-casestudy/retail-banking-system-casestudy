package com.org.Transaction.dao;

import java.time.LocalDate;
import java.util.List;

import com.org.Transaction.model.Transaction;

public interface TransactionDao {
	
	public List<Transaction> getAllTransactions();
	public void saveTransactions(List<Transaction> list);
	public void saveTransaction(Transaction transaction);
	public int getBeneficiary(Long beneficiaryAccNo);
	public List<Transaction> getTransactionsWithFiltersType(String type);
	public List<Transaction> getTransactionsByDate(LocalDate startDate, LocalDate endDate);
	public List<Transaction> getTransactionByAccount(long accNo);
}
