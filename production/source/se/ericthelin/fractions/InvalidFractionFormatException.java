package se.ericthelin.fractions;

public class InvalidFractionFormatException extends IllegalArgumentException {

	private final String text;

	public InvalidFractionFormatException(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
