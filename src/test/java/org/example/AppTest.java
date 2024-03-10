package org.example;

import object.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void TestStringImutableAndIntern() {
        String string = "Hello world";
        System.out.println("String before concat : " + string);
        string.concat("Hello");
        System.out.println("String after concat : " + string);

        String string1 = new String("Hello world");
        System.out.printf("Before intern() string == string1 : %b\n", string == string1);
        string1 = string1.intern();
        System.out.printf("After intern() string == string1 : %b\n", string == string1);
    }

    @Test
    public void TestBigDecimalEquals() {
        BigDecimal zero1 = new BigDecimal("0");
        BigDecimal zero2 = new BigDecimal("0");
        BigDecimal a = new BigDecimal("277");
        BigDecimal b = new BigDecimal("111");
        BigDecimal c = new BigDecimal("277.111");
        BigDecimal d = new BigDecimal("277");
        System.out.printf("a == d : %b\n", a == d);
        System.out.printf("a == b : %b\n", a == b);
        System.out.printf("a == c : %b\n", a == c);
        System.out.printf("a.equals(d) : %b\n", a.equals(d));
        System.out.printf("a.equals(b) : %b\n", a.equals(b));
        System.out.printf("a.equals(c) : %b\n", a.equals(c));
        System.out.printf("a.compareTo(d) : %d\n", a.compareTo(d));
        System.out.printf("a.compareTo(b) : %d\n", a.compareTo(b));
        System.out.printf("a.compareTo(c) : %d\n", a.compareTo(c));
        System.out.printf("a == zero1 : %b\n", a == zero1);
        System.out.printf("a.equals(zero1) : %b\n", a.equals(zero1));
        System.out.printf("a.compareTo(zero1) : %d\n", a.compareTo(zero1));
        System.out.printf("zero1 == zero2 : %b\n", zero1 == zero2);
        System.out.printf("zero1.equals(zero2) : %b\n", zero1.equals(zero2));
        System.out.printf("zero1.compareTo(zero2) : %d\n", zero1.compareTo(zero2));
    }

    @Test
    void TestAlgorithmON() {

    }

    @Test
    void TestA() {
        User user = new User(5, "artur", "abc@mail.ru");
        System.out.println(user);
    }

}
