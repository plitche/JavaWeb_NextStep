package com.nextStep.javaWeb.day_0220;

public class StringCalcMy {

    public int split(String input) {
        String[] splits = String.join(" ", String.join(" ", input.split(",")).split(":")).split(" ");
        int sum = 0;

        for (String split : splits) {
            try {
                int iSplit = Integer.parseInt(split);

                if (iSplit < 0) {
                    throw new RuntimeException();
                }

                sum += iSplit;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sum;
    }

}
