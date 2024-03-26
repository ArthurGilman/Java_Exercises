package org.example;

import core.base.Person;
import jvm.BadPerson;
import jvm.GoodPerson;
import lombok.Getter;
import object.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Test;
import practice.FlatShape;
import practice.Parallelogram;
import practice.Shape;
import practice.Square;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsTest {

    @Test
    public void creatingTreeMapWithComparable() {
        User user_3 = new User(3, "vasya");
        User user_4 = new User(4, "mariaDB");
        User user_1 = new User(1, "leo");
        User user_2 = new User(2, "arturito");
        TreeMap<User, String> treeMap = new TreeMap<>();
        treeMap.put(user_3, user_3.getName());
        treeMap.put(user_4, user_4.getName());
        treeMap.put(user_1, user_1.getName());
        treeMap.put(user_2, user_2.getName());
        treeMap.forEach((u, s) -> System.out.println(u));
    }

    @Test
    public void creatingTreeMapWithComparator() {
        User user_3 = new User(3, "vasya");
        User user_4 = new User(4, "mariaDB");
        User user_1 = new User(1, "leo");
        User user_2 = new User(2, "arturito");
        TreeMap<User, String> treeMap = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId() ;
            }
        });
        treeMap.put(user_3, user_3.getName());
        treeMap.put(user_4, user_4.getName());
        treeMap.put(user_1, user_1.getName());
        treeMap.put(user_2, user_2.getName());
        treeMap.forEach((u, s) -> System.out.println(u));
    }

    @Test
    public void createAndGetMinMaxHashSet() {
        Set<Shape> set = new HashSet<>();
        for (int i = 4000000; i < 9000000; i++) {
            BigDecimal side = BigDecimal.valueOf(i * 2.5);
            set.add(new Square(side, 0));
        }
        for (int i = 0; i < 4000000; i++) {
            BigDecimal side = BigDecimal.valueOf(i * 2.5);
            set.add(new Square(side, 0));
        }
        Shape min = Collections.min(set);
        Shape max = Collections.max(set);
        System.out.println("Min : " + min.getArea());
        System.out.println("Max : " + max.getArea());
    }

    @Test
    public void createAndGetMinMaxTreeSet() {
        SortedSet<Shape> set = new TreeSet<>();
        for (int i = 4000000; i < 9000000; i++) {
            BigDecimal side = BigDecimal.valueOf(i * 2.5);
            set.add(new Square(side, 0));
        }
        for (int i = 0; i < 4000000; i++) {
            BigDecimal side = BigDecimal.valueOf(i * 2.5);
            set.add(new Square(side, 0));
        }
        Shape min = Collections.min(set);

        Shape max = Collections.max(set);

        System.out.println("Min : " + min.getArea());
        System.out.println("Max : " + max.getArea());
    }

    @Test
    public void createAndGetMinMaxLinkedHashSet() {
        Set<Shape> set = new LinkedHashSet<>();
        for (int i = 4000000; i < 9000000; i++) {
            BigDecimal side = BigDecimal.valueOf(i * 2.5);
            set.add(new Square(side, 0));
        }
        for (int i = 0; i < 4000000; i++) {
            BigDecimal side = BigDecimal.valueOf(i * 2.5);
            set.add(new Square(side, 0));
        }

        Shape min = Collections.min(set);

        Shape max = Collections.max(set);

        System.out.println("Min : " + min.getArea());
        System.out.println("Max : " + max.getArea());
    }


    @Test
    public void profilingGetKeyMapWithBadHashcodeTest() {
         Map<BadPerson, String> map = new HashMap<>();
         for (int i = 0; i < 50000; i++) {
             map.put(new BadPerson(i,"artur" + i), "test_" + i);
         }


        String result = map.get(new BadPerson(49000, "artur" + "49000"));
        System.out.println(result);
    }

    @Test
    public void profilingGetKeyMapWithGoodHashcodeTest() {
        Map<GoodPerson, String> map = new HashMap<>();
        for (int i = 0; i < 50000; i++) {
            map.put(new GoodPerson(i,"artur" + i), "test_" + i);
        }


        String result = map.get(new GoodPerson(49000, "artur" + "49000"));
        System.out.println(result);
    }

    @Test
    public void findMaxAreaWithFor() {
        List<FlatShape> list = new ArrayList<>();
        Random rand = new Random(42);
        for (int i = 0; i < 5000; i++) {
            list.add(new Parallelogram(BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    0));
        }
        List<FlatShape> maxArea = new ArrayList<>();
        for (int i = 1; i < list.size(); ++i) {
            FlatShape shape = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1).compareTo(shape) > 0) {
                list.set(j, list.get(j - 1));
                --j;
            }
            list.set(j, shape);
        }
        for (int i = list.size() - 10; i < list.size(); i++) maxArea.add(list.get(i));

        maxArea.forEach(e -> System.out.println(e.getArea()));
    }


    @Test
    public void findMaxAreaWithWhile() {
        List<FlatShape> list = new ArrayList<>();
        Random rand = new Random(42);
        for (int i = 0; i < 5000; i++) {
            list.add(new Parallelogram(BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    0));
        }

        List<FlatShape> maxArea = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            FlatShape shape = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1).compareTo(shape) > 0) {
                list.set(j, list.get(j - 1));
                --j;
            }
            list.set(j, shape);
            i++;
        }
        i = list.size() - 10;
        while (i < list.size()) {
            maxArea.add(list.get(i));
            i++;
        }
        maxArea.forEach(e -> System.out.println(e.getArea()));
    }

    @Test
    public void findMaxAreaWithForEach() {
        List<FlatShape> list = new ArrayList<>();
        Random rand = new Random(42);
        for (int i = 0; i < 5000; i++) {
            list.add(new Parallelogram(BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    0));
        }
        List<FlatShape> maxArea = new ArrayList<>();

        FlatShape max = list.get(0);

        for (int i = 0; i < 10; i++) {
            for (FlatShape shape : list) {
                if (shape.compareTo(max) > 0) max = shape;
            }
            maxArea.add(max);
            list.remove(max);
            max = list.get(0);
        }

        maxArea.forEach(e -> System.out.println(e.getArea()));
    }

    @Test
    public void findMaxAreaWithStream() {
        List<FlatShape> list = new ArrayList<>();
        Random rand = new Random(42);
        for (int i = 0; i < 5000; i++) {
            list.add(new Parallelogram(BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    0));
        }

        list.stream()
                .sorted()
                .skip(list.size() - 10)
                .forEach(e -> System.out.println(e.getArea()));
    }

    @Test
    public void findMaxAreaWithIterator() {
        List<FlatShape> list = new CopyOnWriteArrayList<>();
        Random rand = new Random(42);
        for (int i = 0; i < 5000; i++) {
            list.add(new Parallelogram(BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    BigDecimal.valueOf(Math.abs(rand.nextInt())),
                    0));
        }
        List<FlatShape> maxArea = new ArrayList<>();

        FlatShape max = list.get(0);
        for (int i = 0; i < 10; i++) {
            Iterator<FlatShape> it = list.iterator();
            while (it.hasNext()) {
                FlatShape shape = it.next();
                if (shape.compareTo(max) > 0) max = shape;
            }
            maxArea.add(max);
            list.remove(max);
            max = list.get(0);
        }
        maxArea.forEach(e -> System.out.println(e.getArea()));
    }

}
