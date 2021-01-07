package com.cts.entity;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("TRANSACTION-SERVICE")
@Component
public interface TransactionService {

	@GetMapping("/latestfive/{userId}")
	public List<Transaction> getTransaction(@PathVariable("userId") String userId);
}
