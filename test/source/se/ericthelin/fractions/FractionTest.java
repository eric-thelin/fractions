package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
	public void rejectsTextWithDecimalNumerator() {
		// Given
		String textWithDecimalNumerator = "7.0/5";

		try {
			// When
			Fraction.of(textWithDecimalNumerator);

			// Then
			fail("Nothing thrown");
		} catch (InvalidFractionFormatException e) {
			assertThat(e.getText(), is(textWithDecimalNumerator));
		}
	}

	@Test
	public void rejectsTextWithDecimalDenominator() {
		// Given
		String textWithDecimalDenominator = "7/5.0";

		try {
			// When
			Fraction.of(textWithDecimalDenominator);

			// Then
			fail("Nothing thrown");
		} catch (InvalidFractionFormatException e) {
			assertThat(e.getText(), is(textWithDecimalDenominator));
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
	public void acceptsNegativeInteger() {
		Fraction.of("-7");
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
	public void includesMinusSignOfNegativeOfWholeNumberInStringRepresentation() {
		assertThat(Fraction.of("-7").toString(), is("-7"));
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
	public void beginsStringRepresentationOfNegativeFractionHavingNegativeNumeratorWithMinusSign() {
		assertThat(Fraction.of("-1/3").toString(), is("-1/3"));
	}

	@Test
	public void beginsStringRepresentationOfNegativeFractionHavingNegativeDenominatorWithMinusSign() {
		assertThat(Fraction.of("1/-3").toString(), is("-1/3"));
	}

	@Test
	public void removesDoubleMinusSignsFromStringRepresentation() {
		assertThat(Fraction.of("-1/-3").toString(), is("1/3"));
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
	public void isEqualToFractionWithEqualNumericValue() {
		assertTrue(Fraction.of("4/6").equals(Fraction.of("2/3")));
	}

	@Test
	public void isEqualToFractionWithNegatedValues() {
		assertTrue(Fraction.of("1/3").equals(Fraction.of("-1/-3")));
	}

	@Test
	public void isEqualToOtherNegativeFractionHavingNegatedValues() {
		assertTrue(Fraction.of("-1/3").equals(Fraction.of("1/-3")));
	}

	@Test
	public void doestNotCareAboutPlacementOfSignForEquality() {
		assertTrue(Fraction.of("1/-3").equals(Fraction.of("-1/3")));
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
	public void hasSameHashCodeAsFractionWithSimilarValues() {
		assertThat(Fraction.of("7/5").hashCode(), is(Fraction.of("7/5").hashCode()));
	}

	@Test
	public void hasHashCodeDifferentFromThatOfFractionWithDifferentNumerator() {
		assertThat(Fraction.of("7/5").hashCode(), not(is(Fraction.of("8/5").hashCode())));
	}

	@Test
	public void hasHashCodeDifferentFromThatOfFractionWithDifferentDenominator() {
		assertThat(Fraction.of("7/5").hashCode(), not(is(Fraction.of("7/4").hashCode())));
	}

	@Test
	public void canAddZeroToZero() {
		assertThat(Fraction.ZERO.plus(Fraction.ZERO), is(Fraction.ZERO));
	}

	@Test
	public void canAddZeroToWholeNumber() {
		assertThat(Fraction.of("7").plus(Fraction.ZERO), is(Fraction.of("7")));
	}

	@Test
	public void canAddWholeNumbers() {
		assertThat(Fraction.of("7").plus(Fraction.of("5")), is(Fraction.of("12")));
	}

	@Test
	public void canAddWholeNumberToFraction() {
		assertThat(Fraction.of("4/3").plus(Fraction.of("5")), is(Fraction.of("19/3")));
	}

	@Test
	public void canAddFractionToWholeNumber() {
		assertThat(Fraction.of("5").plus(Fraction.of("4/3")), is(Fraction.of("19/3")));
	}

	@Test
	public void canAddFractionToFraction() {
		assertThat(Fraction.of("7/3").plus(Fraction.of("4/5")), is(Fraction.of("47/15")));
	}

	@Test
	public void reducesSumUsingGreatestCommonDivisor() {
		assertThat(Fraction.of("3/8").plus(Fraction.of("1/8")), is(Fraction.of("1/2")));
	}

	@Test
	public void canAddFractionToNegativeFraction() {
		assertThat(Fraction.of("-1/2").plus(Fraction.of("1/3")), is(Fraction.of("-1/6")));
	}

	@Test
	public void canAddNegativeFractionToFraction() {
		assertThat(Fraction.of("1/2").plus(Fraction.of("-1/3")), is(Fraction.of("1/6")));
	}

	@Test
	public void canAddNegativeFractions() {
		assertThat(Fraction.of("-1/2").plus(Fraction.of("-1/3")), is(Fraction.of("-5/6")));
	}
}
