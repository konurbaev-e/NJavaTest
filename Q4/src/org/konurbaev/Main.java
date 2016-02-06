package org.konurbaev;

public class Main {
    private static final String choice = "sum";
    private static final double simpleNumber = 34.25;
    private static final Double objectNumber = Double.valueOf("34.25");

    public static void main(String[] args) {
        if (objectNumber != null) {
            switch (choice){
                case "sum": System.out.println(simpleNumber + objectNumber);
            }
        }
    }
}
