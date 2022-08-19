package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());

        //FunctionalInteface
        getDBConnectionURLSupplier.get();
    }

    static String getDBConnectionURL(){
        return "jdbc://localhost:3344/user";
    }

    static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:3344/user";
}
