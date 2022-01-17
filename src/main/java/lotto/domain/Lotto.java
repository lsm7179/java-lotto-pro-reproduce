package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = toLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        validate(numbers);
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set lottoNumber = numbers.stream()
                .collect(Collectors.toSet());
        if (lottoNumber.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

}
