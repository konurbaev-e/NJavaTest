package org.konurbaev;

public class Clazz {
    private void process(String... s) {
        System.out.print("*");
    }
    private void process(String s) {
        System.out.print("1");
    }
    private void process(String s, String a) {
        System.out.print("2");
    }
    public static void main(String[] args) {
        Clazz c = new Clazz();
        c.process("asd");
        c.process("asd","asd");
        c.process("asd","asd","asd");
    }
}
