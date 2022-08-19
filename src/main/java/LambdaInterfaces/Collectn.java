package LambdaInterfaces;

import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Collectn {

    public static void main(String args[]) {
        List<String> listOfName = Arrays.asList("Paul", "Jane", "Micheal", "Sam");

        //Prior to lambda, ways to sort
        Collections.sort(listOfName, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(listOfName);

        //Using lambda - First way
        Collections.sort(listOfName, (String a, String b) -> {
            return b.compareTo(a);
        });

        //Using Lambda - Second way
        Collections.sort(listOfName, (a,b) -> b.compareTo(a));


        //Using class
        Book book1 = new Book("This is the book1", "Velroy", "Moras", 10);
        Book book2 = new Book("This is the book2", "Valerian", "Moras", 50);
        Book book3 = new Book("This is the book3", "Jacintha", "Moras", 60);

        //Add all books to the list
        List<Book> Books = Arrays.asList(book1, book2, book3);
        int total = Books.stream().collect(Collectors.summingInt(Book :: getPages ));
        System.out.println(total);


        //Use .collect to aggregate authors first name into a list.
        //and .map to get the last name of the author
        List<String> list = Books.stream().map(Book :: getAuthorLName).collect(Collectors.toList());
        System.out.println(list);
    }
}
