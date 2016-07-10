package se.ericthelin.fractions;

import org.junit.Test;

public class FractionTest {

	@Test(expected = NullPointerException.class)
	public void rejectsNullText() {
		Fraction.of(null);
	}
}
