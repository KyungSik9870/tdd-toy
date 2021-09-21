public class StringCalculator {

	public int splitAndSum(String input) {
		int result = 0;

		if (input == null || input.isEmpty()) {
			return 0;
		} else {
			String[] inputs = input.split(",");
			for (String number : inputs) {
				result += Integer.parseInt(number);
			}
		}
		return result;
	}
}
