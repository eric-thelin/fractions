package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReleaseTest {

	@Test
	public void canAddFractions() {
		// Given
		Fraction augend = Fraction.of("7/3");
		Fraction addend = Fraction.of("4/5");

		// When
		Fraction sum = augend.plus(addend);

		// Then
		assertThat(sum, is(Fraction.of("47/15")));
	}
}
