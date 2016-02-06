package org.konurbaev.a2;

public class Main {
    public static void main(String[] args) {
        //static метод МОЖЕТ быть вызван из нестатического метода
        Title title = new Title();
        title.show();
    }
}
