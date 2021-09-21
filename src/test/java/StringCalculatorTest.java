import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@DisplayName("null 이거나 빈값이면 0을 리턴")
	@Test
	void null_or_empty_return_zero() {
		assertThat(stringCalculator.splitAndSum(null)).isEqualTo(0);
		assertThat(stringCalculator.splitAndSum("")).isEqualTo(0);
	}

	@DisplayName("숫자하나만 전달하면 그대로 리턴")
	@Test
	void singleNumber() {
		assertThat(stringCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@DisplayName("콤마를 구분자로 각 숫자의 합을 계산")
	@Test
	void comma_split_and_sum() {
		assertThat(stringCalculator.splitAndSum("1,2,3")).isEqualTo(6);
	}

	@DisplayName("콤마 또는 콜론을 구분자로 각 숫자의 합을 계산")
	@Test
	void comma_colon_split_and_sum() {
		assertThat(stringCalculator.splitAndSum("1,2:3")).isEqualTo(6);
	}
}
