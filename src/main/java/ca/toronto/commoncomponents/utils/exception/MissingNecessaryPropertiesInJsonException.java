package ca.toronto.commoncomponents.utils.exception;

public class MissingNecessaryPropertiesInJsonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5393591170291484126L;

	public MissingNecessaryPropertiesInJsonException() {
		super();
	}

	public MissingNecessaryPropertiesInJsonException(String message) {
		super(message);
	}

	public MissingNecessaryPropertiesInJsonException(Throwable cause) {
		super(cause);
	}

	public MissingNecessaryPropertiesInJsonException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingNecessaryPropertiesInJsonException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
