package com.org.Transaction.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.Transaction.model.Beneficiary;
import com.org.Transaction.model.Transaction;
import com.org.Transaction.repository.BeneficiaryRepository;
import com.org.Transaction.repository.TransactionRepository;

@Component
public class TransactionDaoImpl implements TransactionDao{

	@Autowired
	private TransactionRepository repo;
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepo;
	
	public List<Transaction> getAllTransactions(){
		return repo.allTransactions();
	}
	
	public void saveTransactions(List<Transaction> list) {
		list.forEach(transaction -> repo.save(transaction));

	}
	public void saveTransaction(Transaction transaction) {
		repo.save(transaction);
	}
	
	public int getBeneficiary(Long beneficiaryAccNo) {
		return beneficiaryRepo.findAll().stream().filter(beneficiary -> beneficiary.getBeneficiaryAccountNumber()==beneficiaryAccNo).collect(Collectors.toList()).size();
		//return beneficiaryRepo.findById(beneficiaryAccNo).get();
	}

	@Override
	public List<Transaction> getTransactionsWithFiltersType(String type) {
		
	return	repo.getTransactionsWithFiltersType(type);
		
	}

	@Override
	public List<Transaction> getTransactionsByDate(LocalDate startDate,LocalDate endDate) {
	return repo. getTransactionsByDate(startDate,endDate);
	}

	@Override
	public List<Transaction> getTransactionByAccount(long accNo) {
		
		return repo.getTransactionByAccount(accNo);
	}

	
}
