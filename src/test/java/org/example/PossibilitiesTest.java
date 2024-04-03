package org.example;


import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class PossibilitiesTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3 ,4 ,5})
    public void switchCaseJava8Test(int number) {
        switch (number) {
            case 1:
                System.out.println("1");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c" ,"d" ,"e"})
    public void switchCaseJava21Test(String str) {
        int res = switch (str) {
            case "a" -> 5;
            default -> 1;
        };
        System.out.println(res);
        switch (str) {
            case "a" -> System.out.println("hi");
            case "e" -> System.out.println("world");
            default -> System.out.println("default");
        }
    }

    @ParameterizedTest()
    @ValueSource(ints = {1, 3, 5})
    public void ternaryOperatorTest(int number) {
        String result;
        result = number > 2 ? "Big": "Small";
        System.out.println(result);

        if (number > 2) result = "Big";
        else result = "Small";
        System.out.println(result);

    }

    @Test
    public void fileReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/artur/IdeaProjects/Java_Exercises/src/test/resources/file.txt"))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void finallyTest() {
        try {
            throw new NullPointerException();
//        } catch (SQLException e) {
//            System.out.println("Caught!");
//            throw new RuntimeException();
        }
        finally {
            return;
        }
    }

}
