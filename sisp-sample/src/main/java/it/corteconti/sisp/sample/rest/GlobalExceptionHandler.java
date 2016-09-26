package it.corteconti.sisp.sample.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.corteconti.sisp.sample.dto.ErrorDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody ErrorDto
	handleNotFound(HttpServletRequest req, Exception ex) {

		LOG.error(ex.getMessage());
	    return new ErrorDto(ex.getMessage());
	} 

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody ErrorDto
	handleInternalServerError(HttpServletRequest req, Exception ex) {

		LOG.error("Rilevata una runtime exception non gestita.", ex);
	    return new ErrorDto(ex.getMessage());
	} 
}
