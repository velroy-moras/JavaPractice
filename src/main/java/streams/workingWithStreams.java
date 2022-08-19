package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class workingWithStreams {

    public static void main(String[] args) {
        List<String> names = List.of("Velroy", "Valerian", "Jacintha", "Jane");
        Stream<String> stream = names.stream();

        List<People> people = List.of(new People("Velroy",18),
                new People("Jacintha", 50),
                new People("Valerian", 55),
                new People("Jane", 13));

       List<People> newList = people.stream()
               .filter(p -> p.getAge() <= 18).limit(2).collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

    static class People{
        private String name;
        private int age;

        People(String name, int age){
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
            return "People{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
