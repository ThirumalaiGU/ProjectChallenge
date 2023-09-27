package com.dws.challenge.ExceptionHandling;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sun.xml.internal.ws.addressing.model.InvalidAddressingHeaderException;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

@ControllerAdvice
public class ExceptionHelper {

	 org.apache.logging.log4j.Logger log = LogManager.getLogger(ExceptionHelper.class);

	@ExceptionHandler(value = { InternalException.class })
	public ResponseEntity<Object> handleInvalidInputException(InvalidAddressingHeaderException ex) {

		log.error("Invalid Input Exception: ", ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {

		log.error("Exception: ", ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
