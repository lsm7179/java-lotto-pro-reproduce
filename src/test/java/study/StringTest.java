package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("1,2을 ,로 나누었을때 검증")
    @Test
    void split1() {
        String[] result = "1,2".split(",");

        assertThat(result).contains(new String[]{"1", "2"});
    }

    @DisplayName("1을 ,로 split 했을때 1만을 포함하는 배열이 반환되는지 검증")
    @Test
    void split2() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 ()을 제거하고 1,2를 반환하도록 검증")
    @Test
    void substring() {
        String given = "(1,2)";

        String result = given.substring(1, 4);

        assertThat(result).isEqualTo("1,2");

    }

    @DisplayName("charAt() 학습테스트")
    @Test
    void charAt() {
        String given = "abc";

        assertThatThrownBy(() -> {
            given.charAt(given.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
