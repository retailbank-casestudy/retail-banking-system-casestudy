package com.retailBanking.accountsService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retailBanking.accountsService.Models.CreditCardModelLite;



public interface CreditCardRepositoryLite extends JpaRepository<CreditCardModelLite,Long> {
	
	@Query("select a from CreditCardModelLite a Where a.userId=?1")
	public List<CreditCardModelLite> getCreditCardNumbers(Double userId) ;


}
