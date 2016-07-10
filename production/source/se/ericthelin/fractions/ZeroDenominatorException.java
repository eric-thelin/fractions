package se.ericthelin.fractions;

public class ZeroDenominatorException extends IllegalArgumentException {
	private final int numerator;

	public ZeroDenominatorException(int numerator) {
		super(String.format(
				"Expected a non-zero denominator, but got \"%s/0\"",
				numerator));

		this.numerator = numerator;
	}

	public int getNumerator() {
		return numerator;
	}
}
