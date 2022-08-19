package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
            int num = incrementByOne(0);
        System.out.println(num);

        Integer integer2 = incrementByOneFunction.apply(1);
        System.out.println(integer2);

        Integer integer3 = multiplyByTen.apply(2);
        System.out.println(integer3);

        Function<Integer, Integer> addBy1AndThenMultipleBy10 = incrementByOneFunction.andThen(multiplyByTen);
       Integer integer4 =  addBy1AndThenMultipleBy10.apply(4);
        System.out.println(integer4);

        Integer integer5 = incrementByOneAndMultiple(3, 10);
        System.out.println(integer5);

        System.out.println(incrementByOneAndMultipleBiFunc.apply(3,4));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByTen = number -> number * 10;

    static int incrementByOne(int num){
        return num+1;
    }

    static int incrementByOneAndMultiple(int num, int numToMultiplyBy){
        return  (num +1) * numToMultiplyBy;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultipleBiFunc = (numberToIncrementByOne, numberToMultBy)
            -> (numberToIncrementByOne + 1) * numberToMultBy;
}
