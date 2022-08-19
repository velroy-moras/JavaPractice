package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "+0091568971713");
        //Normal java function
        greetCustomer(maria);

        //Functional Interface
        greetCustomerFunction.accept(maria);

        //BiConsumer
        greetCustomerFunctionV2.accept(maria,true);
        greetCustomerFunctionV2.accept(maria, false);
    }

    static class Customer{

        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

    static Consumer<Customer> greetCustomerFunction = customer ->  System.out.println("Hello "+customer.customerName + " Thanks for registering "+customer.customerPhoneNumber);

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+customer.customerName + " Thanks for registering "+customer.customerPhoneNumber);
    }

    static BiConsumer<Customer, Boolean> greetCustomerFunctionV2 = (customer, showPhone) ->  System.out.println("Hello "+customer.customerName + " Thanks for registering "+(showPhone ? customer.customerPhoneNumber : "*******"));

}
