package it.corteconti.sisp.sample.dto;

import java.util.List;

public class ValidationErrorDto extends ErrorDto {

	private List<String> validationErrors;

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
}
