package com.ztgg.ecommerce.exceptions;

public class UserOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1731072051960995926L;

	public UserOperationException(String msg) {
		super(msg);
	}
}
