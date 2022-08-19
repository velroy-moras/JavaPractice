package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        //Java functions
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0900000000"));

        //Functional Interface
        System.out.println(isPhoneNumberValid.test("07000000000"));
        System.out.println(isPhoneNumberValid.test("0900000000"));

        //Chaining functional interface
        System.out.println(isPhoneNumberValid.and(containsNumber3).test("07000000000"));
        System.out.println(isPhoneNumberValid.and(containsNumber3).test("07300000000"));
        System.out.println(isPhoneNumberValid.or(containsNumber3).test("07000000000"));
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValid = phoneNumber
            -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber
            -> phoneNumber.contains("3");


}
