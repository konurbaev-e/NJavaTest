package org.konurbaev.a1;

public class Main {
    public static void main(String[] args) {
        //non-static метод не может быть вызван из статического метода
        //без создания экземпляра соответствующего класса
        //Title.show;
        Title title = new Title();
        title.show();
    }
}
