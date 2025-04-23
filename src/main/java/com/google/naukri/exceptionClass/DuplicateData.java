package com.google.naukri.exceptionClass;

public class DuplicateData extends RuntimeException{
	
	private String message;
	
	DuplicateData(){
		
	}
	
	public DuplicateData(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
