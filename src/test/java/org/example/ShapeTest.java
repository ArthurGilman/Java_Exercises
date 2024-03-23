package org.example;

import org.junit.jupiter.api.Test;
import practice.*;

import java.math.BigDecimal;

import static practice.BigDecimalUtils.*;

public class ShapeTest {
    @Test
    public void BigDecimalUtilsTest() {
        final Circle circle = new Circle(BigDecimal.TEN, 0);
        final FlatShape square = new Square(BigDecimal.TEN, 0);
        final Sphere sphere = new Sphere(BigDecimal.TWO, BigDecimal.valueOf(33), 0);
        // Есть взаимная зависимость между высотой и боковой стороной (высота <= боковой стороны),
        // поэтому вместо задания трёх длин лучше использовать длины двух сторон и угол,
        // здесь сделано для простоты
        final FlatShape parallelogram = new Parallelogram(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.TWO, 0);
        final VolumetricShape cube = new Cube(BigDecimal.TEN, BigDecimal.valueOf(15.123), 0);
        final Square sq = null;

        System.out.println("Summary area of all shapes: " + sumArea(circle, square, sphere, parallelogram, cube, sq));
        System.out.println("Summary perimeter of flat shapes: " +
                sumPerimeter(circle, square, parallelogram));
        System.out.println("Summary volume of volumetric shapes: " +
                sumVolume(sphere, cube));
        System.out.println("Average radius of round shapes: " +
                calculateAverageRadius(circle, sphere));
        System.out.println("Summary weight of volumetric shapes: " +
                sumWeight(sphere, cube));
    }

    @Test
    public void BigDecimalAddTest() {
        Sphere sphere = new Sphere(null, null, 5);

    }
}
