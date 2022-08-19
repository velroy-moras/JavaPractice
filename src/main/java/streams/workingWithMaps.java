package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class workingWithMaps {

    public static void main(String[] args) {


        List<String> names = List.of("Velroy", "Valerian", "Jacintha", "Jane");
        Stream<String> stream = names.stream();

        List<Person> people = List.of(new Person("Velroy", 18),
                new Person("Jacintha", 50),
                new Person("Valerian", 55),
                new Person("Jane", 13));


        //Filter
        System.out.println("Printing persons age greater than 50");
       List<Person> age50List =  people.stream().filter(person -> person.getAge() >= 50).collect(Collectors.toList());
       age50List.forEach(System.out::println);

       //Sorting
        System.out.println("\n");
        System.out.println("Printing persons in ascending order with respect to age");
        List<Person> ageAscendingOrder = people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        ageAscendingOrder.forEach(System.out::println);


        //All match : To get a true or false result checks if there is atleast one element.
        boolean allMatch = people.stream().allMatch(person -> person.getAge() > 12);
        System.out.println(allMatch);

        //Any match: Checks if there is atleast one match
        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 60);
        System.out.println(anyMatch);
        System.out.println("\n");

        //None match: To check if there are no match
        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);
        System.out.println();

        //to find the max value in a collection
        people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
        System.out.println();

        //to find the min value in the collection
        people.stream().min(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
        System.out.println();


        //Map
       List<PersonDTO> personDTOS = people.stream()
               .map(person -> {return new PersonDTO(person.getName(),
                                                    person.getAge(),
                                            "Random");})
               .collect(Collectors.toList());
       personDTOS.forEach(System.out:: println);
       }



    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class PersonDTO {
        public PersonDTO(String name, int age, String petname) {
            this.name = name;
            this.age = age;
            this.petname = petname;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getPetname() {
            return petname;
        }

        private String name;
        private int age;
        private String petname;

        @Override
        public String toString() {
            return "PersonDTO{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", petname='" + petname + '\'' +
                    '}';
        }
    }
}