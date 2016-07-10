package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ZeroDenominatorExceptionTest {

	@Test
	public void remembersNumerator() {
		assertThat(new ZeroDenominatorException(42).getNumerator(), is(42));
	}

	@Test
	public void hasInformativeMessage() {
		// Given
		int numerator = 7;

		// When
		ZeroDenominatorException e = new ZeroDenominatorException(numerator);

		// Then
		assertThat(
				e.getMessage(),
				is("Expected a non-zero denominator, but got \"7/0\""));
	}
}