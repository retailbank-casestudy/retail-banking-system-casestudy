package com.retailBanking.accountsService.BusinessLogic;

import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;

public interface First5Accounts {
	
	 List<AccountsModel>  firstFiveAccounts(List<AccountsModel> data);

}
