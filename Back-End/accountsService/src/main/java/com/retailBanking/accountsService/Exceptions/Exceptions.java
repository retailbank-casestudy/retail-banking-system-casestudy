package com.retailBanking.accountsService.Exceptions;

public interface Exceptions {

	Exception noCreditCardFound() throws Exception;

	Exception noTransactionFound() throws Exception;
	
	

}
