package orsys.projet.exception;

public class PaysInexistantException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5761319191510845163L;
	public PaysInexistantException(String message) {
		super(message);
	}
}
