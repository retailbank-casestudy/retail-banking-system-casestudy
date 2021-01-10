package com.org.Transaction.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.Transaction.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select a from Transaction a where a.transactionType=?1")
	List<Transaction> getTransactionsWithFiltersType(String type);
	
	@Query("select a from Transaction a where a.transactionDate BETWEEN ?1 and ?2 ")
	List<Transaction> getTransactionsByDate(LocalDate startDate, LocalDate endDate);

	@Query("select a from Transaction a where a.accountNumber=?1")
	List<Transaction> getTransactionByAccount(long accNo);

	@Query("select a from Transaction a order by a.transactionDate desc")
	List<Transaction> allTransactions();
	
}
