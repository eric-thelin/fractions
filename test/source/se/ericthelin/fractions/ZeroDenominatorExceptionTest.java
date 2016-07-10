package se.ericthelin.fractions;

import org.junit.Test;

public class ZeroDenominatorExceptionTest {

	@Test(expected = NullPointerException.class)
	public void rejectsNullText() {
		new ZeroDenominatorException(null);
	}
}