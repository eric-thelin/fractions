package se.ericthelin.fractions;

public final class GreatestCommonDivisor {
	private GreatestCommonDivisor() {
	}

	public static int of(int first, int second) {
		while (second != 0) {
			int temp = second;
			second = first % second;
			first = temp;
		}

		return first;
	}
}
