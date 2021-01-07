package com.org.Transaction.model;

import java.util.ArrayList;
import java.util.List;



public class AccountList {
	private List<AccountsModel> accounts;
	
	public AccountList() {
		accounts = new ArrayList<>();
	}

	public AccountList(List<AccountsModel> accounts) {
		super();
		this.accounts = accounts;
	}

	

	public List<AccountsModel> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountsModel> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "AccountList [accounts=" + accounts + "]";
	}
	
}
