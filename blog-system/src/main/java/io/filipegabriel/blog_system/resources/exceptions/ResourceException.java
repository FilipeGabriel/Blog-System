package io.filipegabriel.blog_system.resources.exceptions;

import java.time.Instant;
import java.time.format.DateTimeParseException;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ResourceException {
	
	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<StandardError> PropertyValue(PropertyValueException e, HttpServletRequest request){
		String error = "O seguinte campo é obrigatório: " + e.getPropertyName();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError newError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI(), e.getPropertyName());
		return ResponseEntity.status(status).body(newError);
	}
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<StandardError> dateTimeParse(DateTimeParseException e, HttpServletRequest request){
		String error = "Preencha todos os campos do formulário";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError newError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(newError);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<StandardError> dateTimeParse(NullPointerException e, HttpServletRequest request){
		String error = "Preencha todos os campos do formulário";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError newError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(newError);
	}

}
