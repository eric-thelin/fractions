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
		String textZeroDenominator = "7/0";

		try {
			// When
			Fraction.of(textZeroDenominator);

			// Then
			fail("Nothing thrown");
		} catch (ZeroDenominatorException e) {
			assertThat(e.getText(), is(textZeroDenominator));
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
}
