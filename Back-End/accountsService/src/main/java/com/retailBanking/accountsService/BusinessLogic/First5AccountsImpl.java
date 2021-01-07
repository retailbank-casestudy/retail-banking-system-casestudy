package com.retailBanking.accountsService.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.retailBanking.accountsService.Models.AccountsModel;

@Component
public class First5AccountsImpl implements First5Accounts  {
	
	
	public List<AccountsModel>  firstFiveAccounts(List<AccountsModel> data) {
		List<AccountsModel> first5Accounts = new ArrayList<AccountsModel>();
		if (data.size()<5) return data;
		
		for(int i=0;i<data.size()-1;i++)
		{
			if(i<5)
			first5Accounts.add(data.get(i));
			
		}
		
		
		return first5Accounts;
		
	}
	
	
}
