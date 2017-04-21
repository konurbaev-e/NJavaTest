package org.konurbaev.interview;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Step {
    public static double countSteps(long base, long allSteps, double requiredPercentage){
        //double allSteps = Math.log10(Math.pow(base, 4))/Math.log10(base);
        //System.out.println(allSteps);
        //double percentAsExponent = Math.log10(Math.pow(2, -1))/Math.log10(2);
        double percentAsExponent = Math.log10(requiredPercentage)/Math.log10(base);
        System.out.println(percentAsExponent);
        System.out.println(allSteps + percentAsExponent);
        //DecimalFormat df = new DecimalFormat("#.######");
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.valueOf(df.format(allSteps + percentAsExponent));
    }

    public static void main(String[] args) {
        System.out.println(countSteps(2, 59, 0.5));
    }

}
