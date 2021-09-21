public class StringCalculator {

	private static final String REGEX = ",|:";

	public int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		return sum(toInts(input.split(REGEX)));
	}

	private int[] toInts(String[] inputs) {
		int[] numbers = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}

		return numbers;
	}

	private int sum(int[] numbers) {
		int result = 0;
		for (int i = 0; i < numbers.length; i++) {
			result += numbers[i];
		}

		return result;
	}
}
