package LambdaInterfaces;

import java.math.BigInteger;
import java.util.function.*;

public class InterfaceFunctions {

    public static void main(String args[]){

        BiFunction<Integer, Integer, Integer> f1 = (a,b) -> a+b;
        System.out.println(f1.apply(2,3));

        Function<Integer, Integer> f2 = a -> a * a;
        System.out.println(f1.andThen(f2).apply(2,2));
        System.out.println(f2.apply(3));

        //Predicate example
        Predicate<String> stringLen = (s) -> s.length() < 10;
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

        //Consumer example
        Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
        consumerStr.accept("VELROY");

        //Function example
        Function<Integer, String> functionTest = (num) -> Integer.toString(num);
        System.out.println("length of 26: "+ functionTest.apply(26).length());

        //Supplier example
        Supplier<String> s = () -> "This is a string";
        System.out.println(s.get());

        //Binary example
        BinaryOperator<Integer> sum = (a,b) -> a + b;
        System.out.println("Add 10 and 25 is: " + sum.apply(10,25));

        //Unary example
        UnaryOperator<String> str = (msg) -> msg.toUpperCase();
        System.out.println(str.apply("velroy"));


        //Ways of writing methods as lambda functions Eg: Finding the length of the string.
        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("Expected value is 3, Actual value is : "+intToString.apply(123).length());

        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("Expected value is 4, Actual value is : "+intToString2.apply(1234).length());

        //Example of lambda from an constructor, new is a constructor of BigInteger.
        Function<String, BigInteger> stringToInt = BigInteger::new;
        System.out.println("Converting string to int: "+ stringToInt.apply("11234495599"));


        //Example of lambda from an instance method, println is the instance method of System.out.
        Consumer<String> print = System.out::println;
        print.accept("This is a new function");


        UnaryOperator<String> makeGreeetings = "Hello, " :: concat;
        System.out.println(makeGreeetings.apply("Velroy"));


        //Own functional interface
        Calculate add = (x,y) -> x+y;
        Calculate difference = (x,y) -> Math.abs(x-y);
        Calculate divide = (x,y) -> (y!=0? x/y: 0);
        Calculate multiple = (x,y) -> x*y;

        System.out.println(add.calc(2,3));
        System.out.println(difference.calc(5,4));
        System.out.println(divide.calc(5,0));
        System.out.println(divide.calc(10,5));
        System.out.println(multiple.calc(10,5));
    }
}
