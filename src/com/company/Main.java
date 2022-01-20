package com.company;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BiFunction<Integer, Integer, Integer> add = performOperation("add");
        BiFunction<Integer, Integer, Integer> subtract = performOperation("subtract");
        BiFunction<Integer, Integer, Integer> power = performOperation("power");

        System.out.println(add.apply(5,4));
        System.out.println(subtract.apply(5,4));
        System.out.println(power.apply(5,4));



    }

    static BiFunction<Integer, Integer, Integer> performOperation(String operation){
        switch (operation){
            case "add":
                return ((x,y) -> x+y);
            case "subtract":
                return ((x,y) -> x-y);
            case "power":
                return ((x,y) -> (int) Math.pow(x,y));
            default:
                return ((x,y) -> 0);

        }
    }
}
