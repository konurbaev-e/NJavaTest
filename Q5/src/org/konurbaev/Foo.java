package org.konurbaev;

public class Foo {
    private Foo() {
        return this; // 1
    }
    public static Foo get() {
        return new Foo(); // 2
    }
    public static void main(String[] args) {
        Foo foo1 = get(); // 3
        Foo foo2 = new Foo(); // 4
    }
}
