package com.project.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.error.Error;
import com.project.exception.UserNotFoundException;

@RestControllerAdvice
public class ManualExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Error> UserNotFoundExceptionHandler(UserNotFoundException e){
		 Error error = new Error();
		 
		 error.setDate(LocalDateTime.now());
		 error.setMsg(e.getMessage());
		 error.setErrorCode("404 Not found");
		 
		 return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> ExceptionHandlerMeth(Exception e){
		 Error error = new Error();
		 
		 error.setDate(LocalDateTime.now());
		 error.setMsg(e.getMessage());
		 error.setErrorCode("Error");
		 
		 return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	} 
	
}
