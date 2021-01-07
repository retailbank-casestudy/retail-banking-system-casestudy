package com.retailBanking.accountsService.Repository;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.retailBanking.accountsService.Models.Transaction;

@FeignClient(name="transaction-service")
@RibbonClient(name="transaction-service")
@Component
public interface TransactionServiceProxy{
	
	@GetMapping(value="account/{accountNo}",produces = { MediaType.APPLICATION_JSON_VALUE})
	List<Transaction> getTransactionByAccount(@PathVariable("accountNo") long accNo);


}
