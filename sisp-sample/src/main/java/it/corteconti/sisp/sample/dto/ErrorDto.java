package it.corteconti.sisp.sample.dto;

public class ErrorDto {

	private String message;
	
	
	public ErrorDto() {
		// -- Costruttore di default
	}
	
	public ErrorDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
