package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //This prints "This value" Since the value is already present
       Object value =  Optional.ofNullable("This value").orElseGet(()->"Default value");
        System.out.println(value);

        //This prints Default value since the value is null
        Object value1 =  Optional.ofNullable(null).orElseGet(()->"Default value");
        System.out.println(value1);

        //Doesnt throw null pointer exception
        Object value3 = Optional.ofNullable(null);
        System.out.println(value3);

        Optional.ofNullable("veljason@hotmail.com").ifPresentOrElse(email -> System.out.println("Sending email to "+email),
                () -> System.out.println("Cannot send email"));

    }
}
