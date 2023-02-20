package com.nextStep.javaWeb.day_0219;


import com.nextStep.javaWeb.day_0219.StringCalc1_2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

// import org.junit.Test; 사용시 public으로 하지 않으면 run이 안됨. 왜?
public class StringCalc1_2Test3 {

    /*
        중복 코드 제거
            - 테스트를 실행할 때마다 인스턴스를 생성하는 같다.
                : 테스트 메소드를 실행할 때 Calculator의 상태 값이 변경되어 다음 테스트 메소드에 영향을 줄 수 있기 때문에
            - 그럼 왜 @Before 애노테이션을 추천할까?
                : @RunWith, @Rule 같은 애노테이션을 사용해 기능을 확장 가능
                : @Before 안이어야만 @RunWith, @Rule에서 초기화된 객체에 접근할 수 있다는 제약사항이 있다.
            - @Before처럼 @After라는 애노테이션을 사용해 메소드 실행이 끝난 후 실행됨으로써 후처리 작업을 담당한다.
     */

    // 이렇게 해도 자바 문법에는 문제가 없으나 테스트를 실행하기 위한 초기화 작업으로써는 추천하지 않는다.
    // StringCalc1_2 cal = new StringCalc1_2();

    private StringCalc1_2 cal;
    
    @Before // @Before 애노테이션을 활용
    public void setup() {
        cal = new StringCalc1_2();
        System.out.println("before");
    }

    @Test
    public void add() {
        Assert.assertEquals(9, cal.add(6, 3));
        System.out.println("add");
    }

    @Test
    public void subtract() {
        Assert.assertEquals(3, cal.subtract(6, 3));
        System.out.println("subtract");
    }

    @Test
    public void multiply() {
        Assert.assertEquals(18, cal.multiply(6, 3));
        System.out.println("multiply");
    }

    @Test
    public void divide() {
        Assert.assertEquals(2, cal.divide(6, 3));
        System.out.println("divide");
    }

    @After
    public void teardown() {
        System.out.println("teardown");
    }

}
