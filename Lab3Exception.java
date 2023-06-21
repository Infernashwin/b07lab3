package lab3;

public class Lab3Exception extends Exception {
	String message;

	public Lab3Exception(String input) {
		this.message = input;
	}
}
