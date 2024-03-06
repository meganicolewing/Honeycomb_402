package sprint1;

public class InvalidLinkException extends Exception {

	/**
	 * x
	 */
	private static final long serialVersionUID = 1L;
	public InvalidLinkException(String class_type, String class_two, String link_type) {
		super(class_type + " to " + class_two + " as a " + link_type + " is not a valid link");
	}
	
}
