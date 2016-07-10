package se.ericthelin.fractions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FractionTest {

	@Test(expected = NullPointerException.class)
	public void rejectsNullText() {
		Fraction.of(null);
	}

	@Test
	public void hasMeaningfulStringRepresentation() {
		assertThat(Fraction.of("7/5").toString(), is("7/5"));
	}
}
