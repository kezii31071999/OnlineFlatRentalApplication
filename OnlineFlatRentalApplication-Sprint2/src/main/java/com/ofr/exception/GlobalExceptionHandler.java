package com.ofr.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);
	}
	
	@ExceptionHandler(value = FlatBookingNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(FlatBookingNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DuplicateFlatBookingException.class)
	public ResponseEntity<Object> handleNotFoundException(DuplicateFlatBookingException exception, WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(406);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = RegisterationException.class)
	public ResponseEntity<Object> handleAdminRegistrationException(RegisterationException exception,
			WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

	}
	
	@ExceptionHandler(value = DuplicateUserRecordException.class)
	public ResponseEntity<Object> handleDuplicateRecordException(DuplicateUserRecordException exception,
			WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(406);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> handleDuplicateRecordException(UserNotFoundException exception,
			WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(406);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

	}
	
	@ExceptionHandler(value = LandlordNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(LandlordNotFoundException exception, WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = AddLandlordException.class)
	public ResponseEntity<Object> handleAdminRegistrationException(AddLandlordException exception,
			WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

	}
	
	@ExceptionHandler(value=FlatNotFoundException.class)
	public ResponseEntity<Object>handleNotFoundException(FlatNotFoundException exception, WebRequest webRequest){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=ValidFlatDetailsException.class)
	public ResponseEntity<Object> handleValidDetailsException(ValidFlatDetailsException exception,WebRequest webRequest){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
