package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveValidatorTest {

    @DisplayName("잘못된 입력")
    @Test
    void wrongCase() {
        Validator validator = new MoveValidator();
        String str = "d";
        String error = "U 혹은 D";
        assertThatThrownBy(() -> validator.validate(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }
}
