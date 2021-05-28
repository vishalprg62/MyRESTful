package com.intense.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.intense.exception.EmployeeNotFoundException;
import com.intense.response.ExceptionResponse;

@RestControllerAdvice
public class MyExceptioHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(Exception ex, WebRequest request) {
		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>(new ExceptionResponse( new Date(),"validation error",ex.getBindingResult().toString()),HttpStatus.BAD_REQUEST);
	}
}
