package se.ericthelin.fractions;

public class ZeroDenominatorException extends IllegalArgumentException {
	private final String text;

	public ZeroDenominatorException(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
