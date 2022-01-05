package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_PATTERN_REGEX = "//(.)\n(.*)";
    private static final String REGEX = ",|:";
    private static final int DELIMITER_INT = 1;
    private static final int TOKEN_INT = 2;
    private static final Pattern pattern = Pattern.compile(CUSTOM_PATTERN_REGEX);

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_INT);
            String[] tokens = m.group(TOKEN_INT)
                    .split(customDelimiter);
            return sum(tokens);
        }

        String[] texts = text.split(REGEX);
        return sum(texts);
    }

    private static int sum(String[] texts) {
        validateMinus(texts);
        return Arrays.stream(texts)
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y)
                .orElseThrow(NullPointerException::new);
    }

    private static void validateMinus(String[] texts) {
        boolean isMinus = Arrays.stream(texts)
                .map(Integer::parseInt)
                .anyMatch(num -> {
                    return num < 0;
                });
        if (isMinus) {
            throw new RuntimeException();
        }
    }

}
