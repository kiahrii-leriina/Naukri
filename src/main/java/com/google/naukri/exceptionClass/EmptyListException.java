package com.google.naukri.exceptionClass;

public class EmptyListException extends RuntimeException{

	private String message;
	
	EmptyListException(){
		
	}
	
	public EmptyListException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
