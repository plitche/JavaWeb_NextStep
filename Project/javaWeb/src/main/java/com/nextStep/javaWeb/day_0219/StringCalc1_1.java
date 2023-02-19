package com.nextStep.javaWeb.day_0219;

public class StringCalc1_1 {

    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    public static void main(String[] args) {
        /*
            main()는 프로덕션 코드가 정상적으로 동작하는지 확인하기 위한 목적이다.
            일반적으로 main()은 프로그래밍 실행 목적 & 테스트 목적
            여기서는 테스트 목적의 main() 메소드
         */

        /*
            문제점
            1. 프로덕션 코드와 테스트 코드가 같은 클래스에 위치 - 배포할 필요가 없음(테스트 목적)
        */

        StringCalc1_1 cal = new StringCalc1_1();
        System.out.println(cal.add(3, 4));
        System.out.println(cal.subtract(5, 4));
        System.out.println(cal.multiply(2, 6));
        System.out.println(cal.divide(8, 4));

    }
}
