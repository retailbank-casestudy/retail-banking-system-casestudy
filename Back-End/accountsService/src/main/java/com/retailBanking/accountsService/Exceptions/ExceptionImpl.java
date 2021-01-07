package com.retailBanking.accountsService.Exceptions;

import org.springframework.stereotype.Component;

@Component
public class ExceptionImpl implements Exceptions {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7814901565264214069L;

	@Override
	public Exception noCreditCardFound() throws Exception {

		throw new Exception("NoCreditCardFoundException");

	}

	@Override
	public Exception noTransactionFound() throws Exception {
		throw new Exception("NoTransactionFound");
		
	}

}
