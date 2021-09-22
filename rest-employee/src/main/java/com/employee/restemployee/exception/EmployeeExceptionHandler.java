package com.employee.restemployee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.restemployee.model.EmployeeResponseError;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeResponseError> handleException(EmployeeNotFoundException exp){
		
		EmployeeResponseError error = new EmployeeResponseError();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exp.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeResponseError> handleException(Exception exp){
		
		EmployeeResponseError error = new EmployeeResponseError();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exp.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
