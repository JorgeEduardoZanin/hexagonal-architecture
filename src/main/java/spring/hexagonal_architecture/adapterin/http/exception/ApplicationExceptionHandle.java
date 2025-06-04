package spring.hexagonal_architecture.adapterin.http.exception;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import spring.hexagonal_architecture.core.exception.ApplicationException;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ResponseError> applicationException(ApplicationException exception, WebRequest request){
		var response = new ResponseError(Arrays.asList(
				exception.getExceptionType().getErrorMessage()),
				exception.getExceptionType().toString().toUpperCase(),
				HttpStatus.BAD_REQUEST.value(),
				LocalDate.now(),
				request.getDescription(false)
				);
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		var errors = ex.getFieldErrors().stream()
				.map(item -> item.getField() + " " + item.getDefaultMessage())
				.toList();
		
		var response = new ResponseError(
				errors,
				"ERROR_ATTRIBUTE_VALIDATION",
				HttpStatus.BAD_REQUEST.value(),
				LocalDate.now(),
				request.getDescription(false)
				);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		
	}
	
}
