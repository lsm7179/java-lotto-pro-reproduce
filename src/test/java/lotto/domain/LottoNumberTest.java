package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호를 생성")
    @Test
    void lottoNumberCreate() {
        LottoNumber lottoNumber = LottoNumber.from(1);

        assertThat(lottoNumber).isNotNull();

        lottoNumber = LottoNumber.from(45);

        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("1 ~ 45 사이의 숫자가 아니면 예외처리")
    @Test
    void sizeError() {
        assertThatThrownBy(
                () -> LottoNumber.from(46)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> LottoNumber.from(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
