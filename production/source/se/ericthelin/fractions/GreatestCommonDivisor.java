package se.ericthelin.fractions;

public final class GreatestCommonDivisor {
	private GreatestCommonDivisor() {
	}

	public static int of(int first, int second) {
		return Math.max(first, second);
	}
}
