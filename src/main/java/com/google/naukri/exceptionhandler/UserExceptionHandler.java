package com.google.naukri.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.naukri.entity.User;
import com.google.naukri.exceptionClass.DuplicateData;
import com.google.naukri.exceptionClass.EmptyListException;
import com.google.naukri.exceptionClass.InvalidCredentials;
import com.google.naukri.util.ResponseStructure;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<ResponseStructure<User>> invlidCredentials(InvalidCredentials e) {

		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
				.message("Invalid Credentials").body(e.getMessage()).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rs);

		return re;
	}

	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ResponseStructure<User>> emptyListException(EmptyListException e) {
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
				.message("Empty database, no user found").body(e.getMessage()).build();

		ResponseEntity re = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rs);
		return re;
	}

	@ExceptionHandler(DuplicateData.class)
	public ResponseEntity<ResponseStructure<User>> duplicateDate(DuplicateData e) {
		ResponseStructure rs = ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
				.message(" THE GIVEN EMAIL IS ALREADY REGISERED").body(null).build();
		
		ResponseEntity re = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rs);
		
		return re;
	}

}
