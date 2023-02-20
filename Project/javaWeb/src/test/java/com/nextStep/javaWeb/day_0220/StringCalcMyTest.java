package com.nextStep.javaWeb.day_0220;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StringCalcMyTest {

    private StringCalcMy stringCalcMy;

    @Before
    public void before() {
        stringCalcMy = new StringCalcMy();
    }

    @Test
    public void test1() {
        int split = stringCalcMy.split("0,1:2");
        Assertions.assertEquals(split, 3);
    }

    @Test
    public void test2() {
        int split = stringCalcMy.split("0,-1:2");
        Assertions.assertEquals(split, 1);
    }
}
