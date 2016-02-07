package org.konurbaev;

public class Main {
    public static void main(String[] str) {
        String a = new String("hello");
        String b = new String(a);
        String c = a;
        char[] d = { 'h', 'e', 'l', 'l', 'o' };

        System.out.println(a == "hello");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(d));


        String charStr = new String(d);
        System.out.println("NEW:");
        System.out.println(a.equals(charStr));

    }
}
