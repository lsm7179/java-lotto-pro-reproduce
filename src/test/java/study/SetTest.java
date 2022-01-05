package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    @DisplayName("size() 메소드를 활용해 set크기 확인하는 검증")
    @Test
    void set_size() {
        Set<Integer> result = new HashSet<>();

        result.add(1);
        result.add(2);

        assertThat(result.size()).isEqualTo(2);
    }

    @DisplayName("contains 메소드 검증")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void set_contains(int expected) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        assertThat(numbers.contains(expected)).isTrue();
    }

    @DisplayName("CsvSource 학습테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void set_contains2(int input, boolean expected) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
