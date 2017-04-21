package org.konurbaev.interview;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Step {
    public static double countSteps(long base, long allSteps, double requiredPercentage){
        double percentAsExponent = Math.log10(requiredPercentage)/Math.log10(base);
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.UP);
        return Double.valueOf(df.format(allSteps + percentAsExponent));
    }

    public static void main(String[] args) {
        System.out.println(countSteps(2, 59, 0.5));
    }
}
