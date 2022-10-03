package com.tutorial.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.tutorial.Exceptions.ErrorDetails;
import com.tutorial.Exceptions.TutorialNotFound;

@ControllerAdvice
public class ExceptinalHandler {
	
	@ExceptionHandler(TutorialNotFound.class)
	public ResponseEntity<ErrorDetails> tutorialNotFoundException(TutorialNotFound error,WebRequest webRequest){
		
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "BAD REQUEST", error.getMessage());
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandler(NoHandlerFoundException noHandler) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "NOT FOUND", "Not a Valid URL");
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorDetails> httpRequestMethodException(HttpRequestMethodNotSupportedException exception){
		
		ErrorDetails errorDetail = new ErrorDetails(LocalDateTime.now(), HttpStatus.METHOD_NOT_ALLOWED.value(), "Check the http method", exception.getMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetail, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorDetails> missingServletRequestParameterException(MissingServletRequestParameterException exception){
		
		ErrorDetails errorDetail = new ErrorDetails(LocalDateTime.now(), HttpStatus.METHOD_NOT_ALLOWED.value(), "comes from MissingServletRequestParameterException", exception.getMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetail, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
