package be.jebouquine.exceptions;

@SuppressWarnings("serial")
public class JeBouquineBusinessException extends Exception {
	
	public JeBouquineBusinessException() {
	}

	public JeBouquineBusinessException(String arg0) {
		super(arg0);
	}

	public JeBouquineBusinessException(Throwable arg0) {
		super(arg0);
	}

	public JeBouquineBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public JeBouquineBusinessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
