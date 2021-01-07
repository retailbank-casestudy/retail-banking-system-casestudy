package com.org.Transaction.exception;

public class CreditLimitExceededException extends Exception {
	
	private String message;
	
	public CreditLimitExceededException(String message) {
		super(message);
	}
	
}
