public class StringCalculator {

	public int splitAndSum(Input input) {
		if (input.isBlank()) {
			return 0;
		}

		return sum(toInts(input.split()));
	}

	private int[] toInts(String[] values) {
		int[] ints = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			ints[i] = Integer.parseInt(values[i]);
		}

		return ints;
	}

	private int sum(int[] values) {
		int result = 0;
		for (int i = 0; i < values.length; i++) {
			result += values[i];
		}

		return result;
	}

}
