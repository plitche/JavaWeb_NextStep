package com.nextStep.javaWeb.day_0219;

public class StringCalc1_2Test {

    public static void main(String[] args) {
        /*
            문제점
            1. 프로덕션 코드와 테스트 코드가 같은 클래스에 위치 - 배포할 필요가 없음(테스트 목적)
                => 테스트 코드 분리
            2. 메소드 하나에서 프로덕션 코드의 여러 메소드를 동시에 테스트 하고 있다.
               코드 복잡도가 증가할수록 복잡해진다.
                => 메소드 마다 분리
            3. 프로그래밍 시 메소드 하나 하나 구현에 집중한다. 하지만 현재 코드는 모든 메소드를 한번에 테스트 할 수 밖에 없다.
               다른 분제점 은 콘솔에 출력되는 값을 통해 수동으로 확인해야 한다.
                => 해결책 : JUnit
        */

        StringCalc1_2 cal = new StringCalc1_2();
        add(cal);
        subtract(cal);
        multiply(cal);
        divide(cal);
    }

    private static void add(StringCalc1_2 cal) {
        System.out.println(cal.add(9, 3));
    }

    private static void subtract(StringCalc1_2 cal) {
        System.out.println(cal.subtract(9, 3));
    }

    private static void multiply(StringCalc1_2 cal) {
        System.out.println(cal.multiply(9, 3));
    }

    private static void divide(StringCalc1_2 cal) {
        System.out.println(cal.divide(9, 3));
    }
}
