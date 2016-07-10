package se.ericthelin.fractions;

import static java.util.Objects.requireNonNull;

public class ZeroDenominatorException extends IllegalArgumentException {
	private final String text;

	public ZeroDenominatorException(String text) {
		this.text = requireNonNull(text);
	}

	public String getText() {
		return text;
	}
}
