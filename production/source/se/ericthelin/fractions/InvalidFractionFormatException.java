package se.ericthelin.fractions;

import static java.util.Objects.requireNonNull;

public class InvalidFractionFormatException extends IllegalArgumentException {

	private final String text;

	public InvalidFractionFormatException(String text) {
		super(String.format(
				"Expected either a fraction or a whole number, but got \"%s\". " +
						"Valid examples: \"1/2\", \"3\", \"-4/5\", \"-6\", \"78/9\".",
				requireNonNull(text)));

		this.text = text;
	}

	public String getText() {
		return text;
	}
}
