package com.nextStep.javaWeb.day_0220;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalcAnswer {

    /*
        프로덕션 코드를 작성하고 Test 코드를 통해서 검증하고 끝내지 말고,
        프로덕션 코드내에 리팩토링 할 여지가 있는지 체크 && 중복 Test 코드가 없는지 체크
     */

    int add(String text) {
        if (text == null || text.isEmpty()) return 0;

//        (1)
//        if (text.contains(",")) {
//            String[] values = text.split(",");
//            int sum = 0;
//            for (String value : values) {
//                sum += Integer.parseInt(value);
//            }
//
//            return sum;
//        }

        String[] values = text.split(",");
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }

        return sum;
    }

    public static void main(String[] args) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("1,2:3");
        if (m.find()) {
            String custome = m.group(1);

            System.out.println("custome = " + custome);
            String[] tokens = m.group(2).split(custome);

            System.out.println("tokens = " + tokens);

        }

    }

}
