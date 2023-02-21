package com.nextStep.javaWeb.day_0221;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalcAnswer {

    /*
        프로덕션 코드를 작성하고 Test 코드를 통해서 검증하고 끝내지 말고,
        프로덕션 코드내에 리팩토링 할 여지가 있는지 체크 && 중복 Test 코드가 없는지 체크
     */

    int add(String text) {
        if (isBlank(text)) return 0;

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        // 정규식에 text가 매칭이 되면 추출한다.
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) { // 추출이 되면
            String customDelimeter = m.group(1); // 괄호 기준 1, 2
            String[] tokens = m.group(2).split(customDelimeter);
            return tokens;
        }
        /*
        else {
            return text.split(",|:");
        }
        */
        return text.split(",|:");
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i=0; i<values.length; i++) {
//            int number = toPositive(values[i]);
//            numbers[i] = number;

            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
