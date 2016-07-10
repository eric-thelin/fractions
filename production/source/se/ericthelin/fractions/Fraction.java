package se.ericthelin.fractions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Fraction {

	public static final Fraction ZERO = new Fraction(0, 1);

	private static final Pattern FRACTION_PATTERN = Pattern.compile("(\\d+)/(\\d+)");
	private static final Pattern INTEGER_PATTERN = Pattern.compile("\\d+");

	public static Fraction of(String text) {
		Matcher fractionMatcher = FRACTION_PATTERN.matcher(text);

		if (fractionMatcher.matches()) {
			return Fraction.of(
					parseInt(fractionMatcher.group(1)),
					parseInt(fractionMatcher.group(2)));
		}

		Matcher integerMatcher = INTEGER_PATTERN.matcher(text);

		if (integerMatcher.matches()) {
			return Fraction.of(parseInt(integerMatcher.group(0)), 1);
		}

		throw new InvalidFractionFormatException(text);
	}

	private static Fraction of(int numerator, int denominator) {
		if (denominator == 0) {
			throw new ZeroDenominatorException(numerator);
		}

		if (numerator == 0) {
			return ZERO;
		} else {
			int divisor = GreatestCommonDivisor.of(numerator, denominator);

			return new Fraction(numerator / divisor, denominator / divisor);
		}
	}

	private final int numerator;
	private final int denominator;

	private Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		if (denominator == 1) {
			return String.valueOf(numerator);
		}

		return numerator + "/" + denominator;
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

		return numerator == other.numerator
				&& denominator == other.denominator;
	}

	public Fraction plus(Fraction term) {
		return Fraction.of(numerator + term.numerator, 1);
	}
}
