package lotto.domain;

public class LottoNumber {
    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validateSize(number);
        return new LottoNumber(number);
    }

    private static void validateSize(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
