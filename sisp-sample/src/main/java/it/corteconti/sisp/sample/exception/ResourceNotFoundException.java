package it.corteconti.sisp.sample.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String string) {

		super(string);
	}
}
