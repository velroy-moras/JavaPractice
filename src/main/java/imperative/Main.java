package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]) {
        List<Person> people = List.of(new Person("John", Gender.MALE),
                new Person("Velroy", Gender.MALE),
                new Person("Valerian", Gender.MALE),
                new Person("Jacintha", Gender.FEMALE),
                new Person("Jane", Gender.FEMALE));


        //Imperative approach

        System.out.println("Imperative Approach");
        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if(Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for(Person female : females) {
            System.out.println(female);
        }


        //Declarative approach

        System.out.println("Declarative Approach");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List<Person> femaleList = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
                femaleList.forEach(System.out ::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

        enum Gender {
            MALE, FEMALE;
    }
}
