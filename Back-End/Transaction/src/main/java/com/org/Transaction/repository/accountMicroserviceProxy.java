package com.org.Transaction.repository;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.Transaction.model.AccountsModel;



@FeignClient(name="accountsService")
@RibbonClient(name="accountsService")
@Component
public interface accountMicroserviceProxy {
	@GetMapping(value = "/accountsForTransactionService",produces =MediaType.APPLICATION_JSON_VALUE)
	public List<AccountsModel> getaccountsForTransactions(@RequestParam("userid")String id);

}
