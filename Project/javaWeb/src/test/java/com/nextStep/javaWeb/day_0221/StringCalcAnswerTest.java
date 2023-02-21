package com.nextStep.javaWeb.day_0221;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StringCalcAnswerTest {

    private StringCalcAnswer stringCalcAnswer;

    @Before
    public void before() {
        stringCalcAnswer = new StringCalcAnswer();
    }

    @Test
    public void add_null_또는_빈문자() {
        Assertions.assertEquals(0, stringCalcAnswer.add(null));
        Assertions.assertEquals(0, stringCalcAnswer.add(""));
    }

    @Test
    public void add_숫자하나() throws Exception {
        Assertions.assertEquals(1, stringCalcAnswer.add("1"));
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        Assertions.assertEquals(3, stringCalcAnswer.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        Assertions.assertEquals(6, stringCalcAnswer.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_custom_구분자() throws Exception {
        stringCalcAnswer.add("-1,2,3");
    }

}
