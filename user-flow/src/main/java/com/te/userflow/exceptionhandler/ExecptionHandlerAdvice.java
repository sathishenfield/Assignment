package com.te.userflow.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.userflow.exception.AppointmentAlreadyBookedException;
import com.te.userflow.exception.DoctorNotFoundException;
import com.te.userflow.exception.InvalidCredentialException;
import com.te.userflow.exception.NameAlreadyExistException;
import com.te.userflow.response.Response;

@RestControllerAdvice
public class ExecptionHandlerAdvice {

	@ExceptionHandler(NameAlreadyExistException.class)
	public ResponseEntity<Response> nameAlreadyExistException(NameAlreadyExistException exception){
		
		return new ResponseEntity<Response>(Response.builder().msg(exception.getMessage()).
				err(true).data(null).build(),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<Response> invalidCredentialException(InvalidCredentialException exception){
		
		return new ResponseEntity<Response>(Response.builder().msg(exception.getMessage()).
				err(true).data(null).build(),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Response> doctorNotFoundException(DoctorNotFoundException exception){
		
		return new ResponseEntity<Response>(Response.builder().msg(exception.getMessage()).
				err(true).data(null).build(),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(AppointmentAlreadyBookedException.class)
	public ResponseEntity<Response> appointmentAlreadyExistException(AppointmentAlreadyBookedException exception){
		
		return new ResponseEntity<Response>(Response.builder().msg(exception.getMessage()).
				err(true).data(null).build(),HttpStatus.BAD_GATEWAY);
	}
}
