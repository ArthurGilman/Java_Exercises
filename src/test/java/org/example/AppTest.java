package org.example;

import object.User;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    void TestA() {
        User user = new User(5, "artur", "abc@mail.ru");
        System.out.println(user);
    }
}
