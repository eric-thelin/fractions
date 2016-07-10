package se.ericthelin.fractions;

import org.junit.Test;

public class InvalidFractionFormatExceptionTest {

	@Test(expected = NullPointerException.class)
	public void rejectsNullText() {
		new InvalidFractionFormatException(null);
	}
}