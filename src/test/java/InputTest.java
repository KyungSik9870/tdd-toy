import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputTest {
	@Test
	void create() {
		Input input = new Input("");
		assertThat(input).isNotNull();
	}

	@Test
	void 숫자가_아니면_RuntimeException() {
		assertThatThrownBy(
			() -> new Input("a")
		).isInstanceOf(RuntimeException.class);
	}
}
