package se.ericthelin.fractions;

import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class Fraction {

	private static final Pattern FRACTION_PATTERN = Pattern.compile("\\d+/\\d+");
	private static final Pattern INTEGER_PATTERN = Pattern.compile("\\d+");

	public static Fraction of(String text) {
		if (!FRACTION_PATTERN.matcher(text).matches()
				&& !INTEGER_PATTERN.matcher(text).matches()) {
			throw new InvalidFractionFormatException(text);
		}

		return new Fraction(text);
	}

	private final String text;

	private Fraction(String text) {
		this.text = requireNonNull(text);
	}

	@Override
	public String toString() {
		return text;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Fraction)) {
			return false;
		}

		Fraction other = (Fraction) obj;

		return text.equals(other.text);
	}

	public Fraction plus(Fraction term) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
