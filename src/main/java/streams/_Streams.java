package streams;

import imperative.Main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static streams._Streams.Gender.*;

public class _Streams{

    public static void main(String[] args) {
        
        List<Person> people = List.of(new Person("John", MALE),
                new Person("Velroy", MALE),
                new Person("Valerian", MALE),
                new Person("Jacintha", FEMALE),
                new Person("Jane", FEMALE),
                new Person("Julie", PREFER_NOT_TO_SAY)
        );

        people
                .stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println();

        //This is to get only the persons name.
        people.stream().map(person -> person.name).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();


        //If we want to get the length of the name
        people.stream().map(person -> person.name).mapToInt(String::length).forEach(System.out::println);
        System.out.println();

//        Group information based on some condition
        Map<Gender, List<Person>> groupByGender =
                people.stream().collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        } ));


        //All Match: Checking if the complete list has females
       boolean containsOnlyFemales =  people.stream().allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales);


    }

static class Person {
    public Gender getGender() {
        return gender;
    }

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
    MALE, FEMALE, PREFER_NOT_TO_SAY;
}
}
