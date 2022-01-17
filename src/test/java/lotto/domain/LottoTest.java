package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또객체를 생성한다")
    @Test
    void create() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isNotNull();
    }

    @DisplayName("숫자가 6개가 아닐때 에러처리")
    @Test
    void sizeError() {
        assertThatThrownBy(
                () -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 수가 있으면 에러 처리")
    @Test
    void duplicationError() {
        assertThatThrownBy(
                () -> Lotto.from(Arrays.asList(1, 1, 3, 4, 5, 6))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
