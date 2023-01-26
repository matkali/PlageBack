package orsys.projet.exception;

public class UtilisateurInexistantException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7879854743102388113L;
	
	public UtilisateurInexistantException (String message) {
		super(message);
	}

}
