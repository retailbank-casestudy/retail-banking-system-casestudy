package com.org.Transaction.exception;

public class BeneficiaryNotExistsException extends Exception {
	
	private String message;
	
	public BeneficiaryNotExistsException(String message) {
		super(message);
	}
	
}
