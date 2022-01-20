package com.company;

public class FunctionalInterfaceRevision {

    @FunctionalInterface
    interface Greeting{
        String greet(String name);
    }


    public static void main(String[] args) {

        // Method 1: Use Anonymous class to "implement" interface
        Greeting englishGreeting = new Greeting() {
            @Override
            public String greet(String name) {
                return "Hello " + name;
            }
        };

        String greeting1 = englishGreeting.greet("Dela");
        System.out.println(greeting1);


        // Method 2 : Lambda function
        Greeting frenchGreeting = name -> "Allo " + name;
        String greeting2 = frenchGreeting.greet("Esi");
        System.out.println(greeting2);

    }
}
