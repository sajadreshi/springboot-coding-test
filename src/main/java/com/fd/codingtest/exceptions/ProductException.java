package com.fd.codingtest.exceptions;

public class ProductException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductException(String message) {
		 super(message);
	}

	public ProductException(String message, Throwable err) {
		 super(message, err);
	 }


}
