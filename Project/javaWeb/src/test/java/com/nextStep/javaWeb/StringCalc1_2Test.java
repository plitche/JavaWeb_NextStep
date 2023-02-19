package com.nextStep.javaWeb;


import com.nextStep.javaWeb.day_0219.StringCalc1_2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringCalc1_2Test {

    // 전체 메소드 test 혹은 개별 method에 대해서 테스트 가능
    
    @Test
    public void add() {
        StringCalc1_2 cal = new StringCalc1_2();
        System.out.println(cal.add(6, 3));
    }

    @Test
    public void subtract() {
        StringCalc1_2 cal = new StringCalc1_2();
        System.out.println(cal.subtract(6, 3));
    }

    @Test
    public void multiply() {
        StringCalc1_2 cal = new StringCalc1_2();
        System.out.println(cal.multiply(6, 3));
    }

    @Test
    public void divide() {
        StringCalc1_2 cal = new StringCalc1_2();
        System.out.println(cal.divide(6, 3));
    }


}