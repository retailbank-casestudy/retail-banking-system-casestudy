package com.retailBanking.accountsService.AccountTypeSelectionController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retailBanking.accountsService.AccountTypeService.AccountTypeSelectionServiceImpl;
import com.retailBanking.accountsService.Models.AccountsModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountTypeSelectionImpl implements AccountTypeSelection{

	@Autowired
	AccountTypeSelectionServiceImpl service;

	@Override
	@GetMapping(value = "/accountType")
	public List<AccountsModel> getAccountType(@RequestParam(name = "type") String type,@RequestParam(name="id") String id){
Double userID = Double.parseDouble(id);
		
		return	service.getAccountType(type,userID);
		

	}

}
