import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@DisplayName("null 이거나 빈 값으면 0을 리턴")
	@Test
	void nullOrEmpty() {
		assertThat(stringCalculator.splitAndSum(new Input(null))).isEqualTo(0);
		assertThat(stringCalculator.splitAndSum(new Input(""))).isEqualTo(0);
	}

	@DisplayName("하나의 숫자만 넘겼을때는 그대로 리턴")
	@Test
	void singleNumber() {
		assertThat(stringCalculator.splitAndSum(new Input("1"))).isEqualTo(1);
	}

	@DisplayName("쉼표를 구분자로 각 숫자의 합을 확인")
	@Test
	void 쉼표를_구분자로_각숫자의_합을_확인() {
		assertThat(stringCalculator.splitAndSum(new Input("1,2"))).isEqualTo(3);
	}

	@DisplayName("콜론을 구분자로 각 숫자의 합을 확인")
	@Test
	void 콜론을_구분자로_각숫자의_합을_확인() {
		assertThat(stringCalculator.splitAndSum(new Input("1:2"))).isEqualTo(3);
	}

	@DisplayName("쉼표 또는 콜론으로 구분자로 각 숫자의 합을 확인")
	@Test
	void 쉼표_또는_콜론으로_구분자로_각숫자의_합을_확인() {
		assertThat(stringCalculator.splitAndSum(new Input("1:2,3"))).isEqualTo(6);
	}

}
