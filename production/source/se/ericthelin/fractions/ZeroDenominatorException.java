package se.ericthelin.fractions;

import static java.util.Objects.requireNonNull;

public class ZeroDenominatorException extends IllegalArgumentException {
	private final String text;

	public ZeroDenominatorException(String text) {
		super(String.format(
				"Expected a non-zero denominator, but got \"%s\"",
				requireNonNull(text)));

		this.text = text;
	}

	public String getText() {
		return text;
	}
}
