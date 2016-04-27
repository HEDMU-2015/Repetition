package exceptions;

public class PersistenceFailureException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceFailureException(String message) {
		super(message);
	}

}
