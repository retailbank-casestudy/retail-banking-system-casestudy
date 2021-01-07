package com.cts.entity;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient("ACCOUNTSSERVICE")
@Component
public interface AccountService {

	
	@GetMapping("/accountsForHomePage/?id={custId}")
	public List<Account> getLatestAccounts(@RequestParam("custId") long custId);
}
