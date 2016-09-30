package it.corteconti.sisp.sample.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> validationErrors = new ArrayList<>();
	
	public ValidationException() {
		super();
	}
	
	
	public ValidationException(String description) {
		super(description);
	}
	

	public ValidationException(String description, Throwable parent) {
		super(description, parent);
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
	public void addValidationError(String validationError) {
		this.validationErrors.add(validationError);
	}
}
