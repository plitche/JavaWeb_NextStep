package com.nextStep.javaWeb.day_0220;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalcAnswer {

    /*
        프로덕션 코드를 작성하고 Test 코드를 통해서 검증하고 끝내지 말고,
        프로덕션 코드내에 리팩토링 할 여지가 있는지 체크 && 중복 Test 코드가 없는지 체크
     */

    int add(String text) {
        if (isBlank(text)) return 0;

//        (1)
//        if (text.contains(",")) {
//            String[] values = text.split(",");
//            int sum = 0;
//            for (String value : values) {
//                sum += Integer.parseInt(value);
//            }
//            return sum;
//        }

//        (2)
//        String[] values = text.split(",");
//        int sum = 0;
//        for (String value : values) {
//            sum += Integer.parseInt(value);
//        }
//
//        return sum;

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        return text.split(",");
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i=0; i<values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
