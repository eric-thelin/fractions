package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreatestCommonDivisorTest {

	@Test
	public void returnsFirstWhenSecondIsZero() {
		assertThat(GreatestCommonDivisor.of(6, 0), is(6));
	}
}
