package se.dsek.service.user.exception;


public class InvalidUserException extends RuntimeException {

	
	public InvalidUserException(Integer id) {
		super("" + id);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 939667114176300757L;

}
