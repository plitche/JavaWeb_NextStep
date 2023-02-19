package com.nextStep.javaWeb;


import com.nextStep.javaWeb.day_0219.StringCalc1_2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringCalc1_2Test2 {

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

        // 위 문제점 3번의 console에서 출력되는 값을 일일이 다 확인해야 한다는 부분을 해결 => assertEquals()
        /*
            * assertEquals()
                첫 번째 인자는 기다하는 결과 값(expected)
                두 번째 인자는 프로덕션 코드의 메소드를 실행한 결과 값(actual)
                    - int, long, String 등 다양한 데이터 타입 지원
            * assertTrue() : 결과 값이 true/false 인지 확인
            * assertFalse() : 결과 값이 true/false 인지 확인
            * assertNull() : Null 유무 확인
            * assertNotNull() : Null 유무 확인
            * assertArrayEquals() : 배열 값이 같은지를 검증
         */

    @Test
    public void add() {
        StringCalc1_2 cal = new StringCalc1_2();
        Assert.assertEquals(9, cal.add(6, 3));
    }

    @Test
    public void subtract() {
        StringCalc1_2 cal = new StringCalc1_2();
        Assert.assertEquals(3, cal.subtract(6, 3));
    }

    @Test
    public void multiply() {
        StringCalc1_2 cal = new StringCalc1_2();
        Assert.assertEquals(18, cal.multiply(6, 3));
    }

    @Test
    public void divide() {
        StringCalc1_2 cal = new StringCalc1_2();
        Assert.assertEquals(2, cal.divide(6, 3));
    }


}