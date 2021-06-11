package com.residencia.dell.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public ResponseEntity<ErrorMessage> handleConstraintViolation(ConstraintViolationException exception,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorMessage erro = new ErrorMessage("Por favor, verifique os parametros", status.value(),
				exception.getLocalizedMessage(), exception.getClass().getName(), new Date().getTime());

		return ResponseEntity.status(status).body(erro);
	}
}
