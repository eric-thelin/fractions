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
	public void hasMeaningfulStringRepresentation() {
		assertThat(Fraction.of("7/5").toString(), is("7/5"));
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
