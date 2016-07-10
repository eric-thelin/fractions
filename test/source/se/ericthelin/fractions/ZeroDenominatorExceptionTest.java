package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ZeroDenominatorExceptionTest {

	@Test(expected = NullPointerException.class)
	public void rejectsNullText() {
		new ZeroDenominatorException(null);
	}

	@Test
	public void hasInformativeMessage() {
		// Given
		String text = "7/0";

		// When
		ZeroDenominatorException e = new ZeroDenominatorException(text);

		// Then
		assertThat(
				e.getMessage(),
				is("Expected a non-zero denominator, but got \"7/0\""));
	}
}