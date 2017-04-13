package org.konurbaev.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StringConcatWithConsumersAndForEach {
    private static final List<String> fio = Arrays.asList("Petrov","Ivan","Sidorovich");

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final Consumer<String> tokenConsumer = stringBuilder::append;
    private static final Consumer<String> separatorConsumer = tokenConsumer.andThen(str -> stringBuilder.append(" "));

    public static void main(String[] args) {
        fio.forEach(separatorConsumer);
        System.out.println(stringBuilder.toString());
    }
}
