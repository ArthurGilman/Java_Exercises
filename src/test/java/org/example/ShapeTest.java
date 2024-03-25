package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static practice.ShapeUtils.*;

public class ShapeTest {
    @Test
    public void ShapeUtilsTest() {
        final Circle circle = new Circle(BigDecimal.TEN, 0);
        final FlatShape square = new Square(BigDecimal.TEN, 0);
        final Sphere sphere = new Sphere(BigDecimal.TWO, BigDecimal.valueOf(33), 0);
        // Есть взаимная зависимость между высотой и боковой стороной (высота <= боковой стороны),
        // поэтому вместо задания трёх длин лучше использовать длины двух сторон и угол,
        // здесь сделано для простоты
        final FlatShape parallelogram = new Parallelogram(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.TWO, 0);
        final VolumetricShape cube = new Cube(BigDecimal.TEN, BigDecimal.valueOf(15.123), 0);

        BigDecimal sumAreaRes = BigDecimal.valueOf(1049.29172);
        Assertions.assertEquals(sumAreaRes, sumArea(circle, square, sphere, parallelogram, cube));

        BigDecimal sumPerimeterRes = BigDecimal.valueOf(126.8318);
        Assertions.assertEquals(sumPerimeterRes.setScale(5, RoundingMode.HALF_UP), sumPerimeter(circle, square, parallelogram));

        BigDecimal sumVolumeRes = BigDecimal.valueOf(1033.51029);
        Assertions.assertEquals(sumVolumeRes, sumVolume(sphere, cube));

        BigDecimal radiusRes = BigDecimal.valueOf(6);
        Assertions.assertEquals(radiusRes, calculateAverageRadius(circle, sphere));


        BigDecimal expectedWeight = BigDecimal.valueOf(48.123);
        Assertions.assertEquals(expectedWeight, sumWeight(sphere, cube));
    }

    @Test
    public void CreateCircleWithNegativeParametersTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle(BigDecimal.valueOf(-1), 0);
        });
    }

    @Test
    public void CreateSquareWithNegativeParametersTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            FlatShape square = new Square(BigDecimal.valueOf(-1), 0);
        });
    }

    @Test
    public void CreateSphereWithNegativeParametersTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Sphere sphere = new Sphere(BigDecimal.TWO, BigDecimal.valueOf(-33), 0);
        });
    }
    @Test
    public void CreateParallelogramWithNegativeParametersTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            FlatShape parallelogram = new Parallelogram(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.valueOf(-3), 0);
        });
    }

    @Test
    public void CreateCubeWithNegativeParametersTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            VolumetricShape cube = new Cube(BigDecimal.TEN, BigDecimal.valueOf(-15.123), 0);
        });
    }

}
