package com.retailBanking.accountsService.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.retailBanking.accountsService.Models.CreditCardModel;

public interface CreditCardRepository extends JpaRepository<CreditCardModel, Long>{

	@Query("select a from CreditCardModel a Where a.accountNo=?1")
	public List<CreditCardModel> getCreditCardDetatils(long accountNo) ;

	@Query("select a from CreditCardModel a Where a.accountNo=?1")
	public CreditCardModel getCreditCard(Long accNo);
		
}
