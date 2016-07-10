package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InvalidFractionFormatExceptionTest {

	@Test(expected = NullPointerException.class)
	public void rejectsNullText() {
		new InvalidFractionFormatException(null);
	}

	@Test
	public void hasInformativeMessage() {
		// Given
		String text = "foo";

		// When
		InvalidFractionFormatException e = new InvalidFractionFormatException(text);

		// Then
		assertThat(
				e.getMessage(),
				is("Expected either a fraction or a whole number, but got \"foo\". " +
						"Valid examples: \"1/2\", \"3\", \"-4/5\", \"-6\", \"78/9\"."));
	}
}