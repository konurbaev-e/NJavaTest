package org.konurbaev.a5;

public class Main {

    private void show (){
        System.out.println("I am non-static метод");
    }

    public static void main(String[] args) {
        Main main = new Main();
        //private-метод МОЖЕТ быть вызван из другого метода этого класса
        main.show();
    }
}
