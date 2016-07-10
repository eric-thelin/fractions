package se.ericthelin.fractions;

import static java.util.Objects.requireNonNull;

public class InvalidFractionFormatException extends IllegalArgumentException {

	private final String text;

	public InvalidFractionFormatException(String text) {
		this.text = requireNonNull(text);
	}

	public String getText() {
		return text;
	}
}
