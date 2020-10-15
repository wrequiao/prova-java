package br.com.confidencecambio.exception;

public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = 6666045271614521618L;

	public GeneralException() {
		super();
	}

	public GeneralException(String message) {
		super(message);
	}
}