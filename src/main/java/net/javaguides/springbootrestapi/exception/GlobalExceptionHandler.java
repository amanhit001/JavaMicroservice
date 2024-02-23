package net.javaguides.springbootrestapi.exception;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"User_NOT_Found"
				
				);
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ErrorDetails> handleEmailAlreadyExists(EmailAlreadyExistsException exception,WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"User_Email_Already_Exists"
				);
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	

}
