package com.retailBanking.accountsService.AccountTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailBanking.accountsService.AccountRecordController.AccountRecord;
import com.retailBanking.accountsService.Models.AccountsModel;

@Service
public class AccountTypeSelectionServiceImpl implements AccountTypeSelectionService {
	@Autowired
	AccountRecord record;

	@Override
	public List<AccountsModel> getAccountType(String type )  {
		
	return record.getAllAccountsListforType(type);
				
				
	}

}
