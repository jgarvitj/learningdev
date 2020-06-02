package junit.exception;

public class NameTooShortException extends Exception {
	
	private String message;
	
	public NameTooShortException() {
		this.message = "Name too short";
	}
	
	public NameTooShortException(String message) {
		System.out.println("NameTooShort Exception called");
		this.message = message;
	}
	@Override
	public String toString() {
		return "NameTooShortException [message=" + message + "]";
	}
}
