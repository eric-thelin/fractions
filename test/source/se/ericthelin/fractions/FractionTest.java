package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FractionTest {

	@Test(expected = NullPointerException.class)
	public void rejectsNullText() {
		Fraction.of(null);
	}

	@Test
	public void rejectsTextWithLetters() {
		// Given
		String textWithLetters = "foo 7/5 bar";

		try {
			// When
			Fraction.of(textWithLetters);

			// Then
			fail("Nothing thrown");
		} catch (InvalidFractionFormatException e) {
			assertThat(e.getText(), is(textWithLetters));
		}
	}

	@Test
	public void rejectsTextWithMultipleSlashes() {
		// Given
		String textWithMultipleSlashes = "7/5/3";

		try {
			// When
			Fraction.of(textWithMultipleSlashes);

			// Then
			fail("Nothing thrown");
		} catch (InvalidFractionFormatException e) {
			assertThat(e.getText(), is(textWithMultipleSlashes));
		}
	}

	@Test
	public void rejectsTextWithZeroDenominator() {
		// Given
		String textWithZeroDenominator = "7/0";

		try {
			// When
			Fraction.of(textWithZeroDenominator);

			// Then
			fail("Nothing thrown");
		} catch (ZeroDenominatorException e) {
			assertThat(e.getNumerator(), is(7));
		}
	}

	@Test
	public void rejectsTextWithZeroNumeratorAndDenominator() {
		// Given
		String textWithZeroNumeratorAndDenominator = "0/0";

		try {
			// When
			Fraction.of(textWithZeroNumeratorAndDenominator);

			// Then
			fail("Nothing thrown");
		} catch (ZeroDenominatorException e) {
			assertThat(e.getNumerator(), is(0));
		}
	}

	@Test
	public void acceptsTextWithJustDigits() {
		Fraction.of("7");
	}

	@Test
	public void hasMeaningfulStringRepresentation() {
		assertThat(Fraction.of("7/5").toString(), is("7/5"));
	}

	@Test
	public void simplifiesStringRepresentationWhenDenominatorIsOne() {
		assertThat(Fraction.of("7/1").toString(), is("7"));
	}

	@Test
	public void hidesDenominatorOfWholeNumber() {
		assertThat(Fraction.of("7").toString(), is("7"));
	}

	@Test
	public void simplifiesStringRepresentationOfZeroFraction() {
		assertThat(Fraction.of("0/5").toString(), is("0"));
	}

	@Test
	public void usesGreatestCommonDivisorToSimplifyRepresentation() {
		assertThat(Fraction.of("4/6").toString(), is("2/3"));
	}

	@Test
	public void isEqualToSelf() {
		// Given
		Fraction instance = Fraction.of("7/5");

		// Then
		assertTrue(instance.equals(instance));
	}

	@Test
	public void isEqualToFractionWithSimilarValues() {
		assertTrue(Fraction.of("7/5").equals(Fraction.of("7/5")));
	}

	@Test
	public void isEqualToZeroWhenNumeratorIsZero() {
		assertTrue(Fraction.of("0/5").equals(Fraction.of("0")));
	}

	@Test
	public void isEqualToFractionWithEqualNumericalValue() {
		assertTrue(Fraction.of("4/6").equals(Fraction.of("2/3")));
	}

	@Test
	public void isNotEqualToNull() {
		assertFalse(Fraction.of("7/5").equals(null));
	}

	@Test
	public void isNotEqualToDifferentType() {
		assertFalse(Fraction.of("7/5").equals("7/5"));
	}

	@Test
	public void isNotEqualToFractionWithSimilarNumeratorButDifferentDenominator() {
		assertFalse(Fraction.of("7/5").equals(Fraction.of("7/4")));
	}

	@Test
	public void isNotEqualToFractionWithSimilarDenominatorButDifferentNumerator() {
		assertFalse(Fraction.of("7/5").equals(Fraction.of("8/5")));
	}

	@Test
	public void canAddZeroToZero() {
		assertThat(Fraction.ZERO.plus(Fraction.ZERO), is(Fraction.ZERO));
	}
}
