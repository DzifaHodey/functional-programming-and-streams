package com.company;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalComposition {

    public static void main(String[] args) {

        // Manual
        Predicate<String> hasValidEmail = email -> email.contains("@");
        Predicate<Integer> isOfAge = (Integer age) -> age >= 18;

        BiPredicate<String, Integer> hasValidEmailAndCanVote =
                (email, age) -> hasValidEmail.test(email) && isOfAge.test(age);

        boolean result = hasValidEmailAndCanVote.test("kojo@gmail.com", 18);
        System.out.println("Candidate can vote? " + result);


        /*
        PREDICATE COMPOSITION :
        and(), or(), negate(), isEqual(), not()
        */

        // and()
        User akos = new User("hey@gmail.com", 28.00);
        Predicate<User> userHasValidEmail = user -> user.getEmail().contains("@") && user.getEmail().contains(".");
        Predicate<User> userHasEnoughBalance = user -> user.getBalance() > 50.0;

        Boolean userValidation = userHasValidEmail
                .and(userHasEnoughBalance)
                .test(akos);

        System.out.println("Can customer make purchase? " + userValidation);


        // or()
        Boolean isValidCustomer = userHasValidEmail
                .or(userHasEnoughBalance)
                .test(akos);
        System.out.println("Valid customer? " + isValidCustomer);

        // negate()
        Predicate<User> customerHasInvalidEmail = userHasValidEmail.negate();
        System.out.println("Akos has invalid email? " + customerHasInvalidEmail.test(akos));

        // not()
        Predicate<User> userHasInsufficientBalance = Predicate.not(userHasEnoughBalance);
        System.out.println("Insufficient balance? " + userHasInsufficientBalance.test(akos));

        // isEqual()
        Predicate<Double> sameBalance = Predicate.isEqual(128.00);
        System.out.println("Does customer have the same balance? " + sameBalance.test(akos.getBalance()));


        /*
        * FUNCTION COMPOSITION
        * compose(), andThen()
        * */

        // compose()
        // returns a composed function that first applies
        // function inside parenthesis and then applies function outside parenthesis on the result
        // eg: f(g())
        Function<Integer, Integer> addTwo = (Integer a) -> 2 + a;
        Function<Integer, Integer> subOne = (Integer a) -> a - 1;
        Function<Integer, Integer> mulThree = (Integer a) -> 3 * a;

        // (5*3)+2, ie, addTwo(mulThree(5))
        Integer composeResult = addTwo.compose(mulThree).apply(5);
        System.out.println(composeResult);

        // ((5-1)*3)+2
        Integer composeResult2 = addTwo
                .compose(mulThree)
                .compose(subOne)
                .apply(5);
        System.out.println(composeResult2);


        // andThen() : returns a composed function that first applies
        // function outside parenthesis and then applies function inside parenthesis on the result
        // ((5-1)*3)+2
        Integer andThenResult = subOne
                .andThen(mulThree)
                .andThen(addTwo)
                .apply(5);
        System.out.println(andThenResult);



    }

    static class User {
        private String email;
        private Double balance;

        public User(String email, Double balance) {
            this.email = email;
            this.balance = balance;
        }

        public String getEmail() {
            return email;
        }

        public Double getBalance() {
            return balance;
        }
    }
}
