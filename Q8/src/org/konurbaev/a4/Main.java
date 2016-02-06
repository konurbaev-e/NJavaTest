package org.konurbaev.a4;

public class Main {

    private void show (){
        System.out.println("I am non-static метод");
        //non-static метод не может быть вызван из другого
        //нестатического метода без создания экземпляра этого класса
        //Title.show;
        Title title = new Title();
        title.show();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.show();
    }
}
