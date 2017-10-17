package br.com.hammersoft.poddy.api.exception;

public class PoddyAPIException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3845459176520728225L;

	public PoddyAPIException() {
	}

	public PoddyAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PoddyAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public PoddyAPIException(String message) {
		super(message);
	}

	public PoddyAPIException(Throwable cause) {
		super(cause);
	}
}
