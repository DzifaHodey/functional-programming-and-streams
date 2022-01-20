package com.company;

import java.util.function.*;

public class FunctionsRevision {

    public static void main(String[] args) {

        // FUNCTION, functional method => apply
        Function<String, String> greeting1 = name -> "Hello " + name;
        String paul = greeting1.apply("Paul");
        System.out.println(paul);

        Function<Integer, Integer> multiplyByTwo = number -> 2 * number;
        System.out.println(multiplyByTwo.apply(5));

        // SUPPLIER, functional method => get
        Supplier<String> fruits = () -> "Banana, Pawpaw";
        System.out.println(fruits.get());

        // CONSUMER, functional method => accept
        Consumer<Double> account = balance -> System.out.println("Balance: " + balance);
        account.accept(58.0);

        // consumer can be used to print and
        Consumer<Double> wallet = amount -> {};
        wallet.accept(8905.00);

        // PREDICATE, functional method => test
        Predicate<Integer> canVote = age -> age >= 18;
        System.out.println(canVote.test(15));
        System.out.println(canVote.test(25));

        // UNARY OPERATOR, functional method => apply
        UnaryOperator<Integer> decrement = number -> number -1;
        System.out.println(decrement.apply(20));

        UnaryOperator<String> convertToCaps = word -> word.toUpperCase();
        System.out.println(convertToCaps.apply("okay"));


        // BINARY OPERATOR, apply
        BinaryOperator<Integer> addTwoNumbers = (a, b) -> a+b;
        System.out.println(addTwoNumbers.apply(31,22));

        // INT TO DOUBLE, apply
        IntToDoubleFunction doubleFunction = num -> Double.parseDouble(String.valueOf(num));
        System.out.println(doubleFunction.applyAsDouble(25));



    }
}
