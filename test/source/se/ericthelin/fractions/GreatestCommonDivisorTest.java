package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreatestCommonDivisorTest {

	@Test
	public void returnsFirstWhenSecondIsZero() {
		assertThat(GreatestCommonDivisor.of(6, 0), is(6));
	}

	@Test
	public void returnsSecondWhenFirstIsZero() {
		assertThat(GreatestCommonDivisor.of(0, 4), is(4));
	}

	@Test
	public void returnsGreatestCommonDivisorOfFirstAndSecond() {
		assertThat(GreatestCommonDivisor.of(6, 4), is(2));
	}

	@Test
	public void acceptsArgumentsInReverseOrder() {
		assertThat(GreatestCommonDivisor.of(4, 6), is(2));
	}

	@Test
	public void acceptsNegativeFirstArgument() {
		assertThat(GreatestCommonDivisor.of(-6, 4), is(-2));
	}

	@Test
	public void acceptsNegativeSecondArgument() {
		assertThat(GreatestCommonDivisor.of(6, -4), is(2));
	}

	@Test
	public void acceptsBothArgumentsNegative() {
		assertThat(GreatestCommonDivisor.of(-6, -4), is(-2));
	}

	@Test
	public void canComputeGreatestCommonDivisorOfLargeArguments() {
		assertThat(GreatestCommonDivisor.of(1071, 462), is(21));
	}
}
