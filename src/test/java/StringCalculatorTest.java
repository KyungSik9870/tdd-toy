import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@DisplayName("null 이거나 빈값이면 0을 리턴")
	@Test
	void null_or_empty_return_zero() {
		StringCalculator stringCalculator = new StringCalculator();
		assertThat(stringCalculator.splitAndSum(null)).isEqualTo(0);
		assertThat(stringCalculator.splitAndSum("")).isEqualTo(0);
	}

	@DisplayName("숫자하나만 전달하면 그대로 리턴")
	@Test
	void singleNumber() {
		StringCalculator stringCalculator = new StringCalculator();
		assertThat(stringCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@DisplayName("콤마를 구분자로 각 숫자의 합을 계산")
	@Test
	void comma_split_and_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		assertThat(stringCalculator.splitAndSum("1,2,3")).isEqualTo(6);
	}
}
