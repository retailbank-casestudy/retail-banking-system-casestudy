package com.retailBanking.accountsService.AccountTypeService;

import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;

public interface AccountTypeSelectionService {

	
	
	List<AccountsModel> getAccountType(String type);

}
