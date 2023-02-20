package com.nextStep.javaWeb.day_0220;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SplitTest {

    @Test
    public void split() {
        String[] values = "1".split(",");
        Assertions.assertArrayEquals(new String[] {"1"}, values);

        values = "1,2".split(",");
        Assertions.assertArrayEquals(new String[] {"1" , "2"}, values);
    }
}
