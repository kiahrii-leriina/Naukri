package com.google.naukri.exceptionClass;

public class InvalidCredentials extends RuntimeException{

	
	private String message;
	
	InvalidCredentials(){
		
	}
	
	public InvalidCredentials(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}