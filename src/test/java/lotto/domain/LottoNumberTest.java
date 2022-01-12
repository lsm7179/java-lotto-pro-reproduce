package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @DisplayName("로또 번호를 생성")
    @Test
    void lottoNumberCreate() {
        LottoNumber lottoNumber = new LottoNumber(3);

        assertThat(lottoNumber).isNotNull();
    }
}
