package exceptions;

public class PersistenceCommitFailureException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceCommitFailureException(String message) {
		super(message);
	}

}
