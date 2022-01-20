package com.company.StreamsRevisionComp;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamsRevision {
    public static void main(String[] args) {

        /* Create a stream */

        int integerSum = Stream.of(1, 23, 5, 6, 7)
                .mapToInt(value -> value)       // or .mapToInt(Integer::IntValue)
                .sum();


        Stream<String> nameStream = Stream.of("John", "Peter", "Emmanuel");

        // Arrays
        float[] scores = {21.3F, 67.4F, 99.8F};
        Stream<float[]> scoreStream = Stream.of(scores);

        // discard array but keep content as primitive data
        double[] prices = {23.50, 199.99, 45.6};
        DoubleStream priceStream = Arrays.stream(prices);
        double sum = Arrays.stream(prices).sum();


        // From collections
        List<String> names = List.of("Dee", "Pee", "Tee");
        Stream<String> newNameStream = names.stream();


        // Builder Pattern
        Stream<Object> buildStream =
                Stream.builder().add(1).add(34).add(300).build();

        // Empty stream, acts as an optional
        // used for methods whose return type is to return
        Stream<Object> emptyStream = Stream.empty();
//        emptyStream.peek(System.out::println);


        // Generate random values in stream
        // limit adds a cap, else it would be infinite
        List<Double> doubleList =
                Stream.generate(
                                () -> new Random().nextDouble()
                        )
                        .limit(5)
                        .collect(Collectors.toList());

        System.out.println(doubleList);

        List<Integer> integerList =
                Stream.generate(
                                () -> new Random().nextInt(100)
                        )
                        .limit(3)
                        .toList();
        System.out.println(integerList);

    }

}
