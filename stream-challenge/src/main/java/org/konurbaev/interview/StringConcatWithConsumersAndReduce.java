package org.konurbaev.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StringConcatWithConsumersAndReduce {
    private static final List<String> fio = Arrays.asList("Petrov","Ivan","Sidorovich");

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final Consumer<String> tokenConsumer = stringBuilder::append;
    private static final Consumer<String> separatorConsumer = tokenConsumer.andThen(str -> stringBuilder.append(" "));

    public static void main(String[] args) {
        Consumer<List<String>> requestConsumer = chain(StringConcatWithConsumersAndReduce::printLastName, StringConcatWithConsumersAndReduce::printFirstName, StringConcatWithConsumersAndReduce::printMiddleName);
        requestConsumer.accept(fio);
        System.out.println(stringBuilder.toString());
    }

    @SafeVarargs
    private static Consumer<List<String>> chain(Consumer<List<String>>... handlers) {
        //noinspection ConstantConditions
        return Stream.of(handlers).reduce(Consumer::andThen).get();
    }

    private static void printLastName(List<String> fio){
        separatorConsumer.accept(fio.get(0));
    }

    private static void printFirstName(List<String> fio){
        separatorConsumer.accept(fio.get(1));
    }

    private static void printMiddleName(List<String> fio){
        separatorConsumer.accept(fio.get(2));
    }

}
