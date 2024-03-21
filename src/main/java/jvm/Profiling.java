package jvm;

import algorithms.Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profiling {

    public static void memoryTestON(List<Integer> list) {
        Algo algo = new Algo();
        System.out.println(algo.memoryON(list));
    }

    public static void memoryTestON2(List<Integer> list) {
        Algo algo = new Algo();
        System.out.println(algo.memoryON2(list));
    }

    public static void memoryTestOLogN(List<Integer> list) {
        Algo algo = new Algo();
        System.out.println(algo.memoryOLogN(list, 222222));
    }

    public static void memoryLeak() {
        Map<Person, Integer> map = new HashMap<>();

        for(int i = 0; i < 10000000; i++) {
            if (i % 100_000 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            map.put(new Person("artur"), 1);
        }

    }



}
