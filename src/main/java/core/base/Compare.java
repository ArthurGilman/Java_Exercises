package core.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compare {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("victor", 55));
        list.add(new Person("dima", 10));
        list.add(new Person("maria", 11));
        list.add(new Person("db", 5));

        Collections.sort(list);
    }
}
