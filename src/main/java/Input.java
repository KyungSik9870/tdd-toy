public class Input {
	private String input;
	private static final String CONDITION_REGEX = "^[0-9]*$";
	private static final String SPLIT_REGEX = ",|:";

	public Input(String input) {
		this.input = input;
	}

	public boolean isBlank() {
		return this.input == null || this.input.isEmpty();
	}

	public String[] split(){
		return this.input.split(SPLIT_REGEX);
	}
}
