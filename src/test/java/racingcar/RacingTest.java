package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp(){
        racing = new Racing();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
    void validateCarNames_shouldThrowException_whenNameLongerThan5() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> racing.validateCarNames("abcdef")
        );

        assertEquals("자동차 이름은 5자 이하만 가능합니다.", e.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 영문자 이외의 문자가 포함된 경우 예외 발생")
    void validateCarNames_shouldThrowException_whenContainsNonAlphabet() {
        IllegalArgumentException ex1 = assertThrows(
                IllegalArgumentException.class,
                () -> racing.validateCarNames("abcd1")
        );
        assertEquals("자동차 이름은 영문자만 가능합니다.", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(
                IllegalArgumentException.class,
                () -> racing.validateCarNames("이름.")
        );
        assertEquals("자동차 이름은 영문자만 가능합니다.", ex2.getMessage());
    }
}
