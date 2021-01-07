package com.cts.RewardApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidClaimRewardException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  public InvalidClaimRewardException(String message) {
	        super(message);
	    }

}
