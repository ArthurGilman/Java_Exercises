package core.base;

import lombok.Getter;
import lombok.Setter;

public class Person implements Comparable<Person> {

    @Getter
    private String name;
    @Setter
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return age - person.age;
    }
}
