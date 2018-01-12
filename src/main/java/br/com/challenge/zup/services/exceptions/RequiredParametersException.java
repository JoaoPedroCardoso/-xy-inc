package br.com.challenge.zup.services.exceptions;

public class RequiredParametersException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RequiredParametersException(String msg) {
		super(msg);
	}
	
	public RequiredParametersException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
