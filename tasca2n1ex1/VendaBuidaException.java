package tasca2n1ex1;

public class VendaBuidaException extends Exception {

	private static final long serialVersionUID = 1L; // com Exception implementa serializable, he de posarli aquest
														// numero (o supresswarning "serial")

	public VendaBuidaException(String message) {
		super(message);
	}

}
