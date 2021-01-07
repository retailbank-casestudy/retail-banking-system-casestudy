package com.retailBanking.accountsService.AccountTypeSelectionController;

import java.io.IOException;
import java.util.List;

import com.retailBanking.accountsService.Models.AccountsModel;

public interface AccountTypeSelection {
	
	
	List<AccountsModel> getAccountType(String type) throws IOException;

	
}
