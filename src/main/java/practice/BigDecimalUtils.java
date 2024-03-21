package practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class BigDecimalUtils {
    public static final BigDecimal PI = BigDecimal.valueOf(3.14159);

    public static BigDecimal sumArea(Shape... shapes) {
        return Arrays.stream(shapes)
                .map(Shape::getArea)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    public static BigDecimal sumPerimeter(FlatShape... shapes) {
        return Arrays.stream(shapes)
                .map(FlatShape::getPerimeter)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    public static BigDecimal sumVolume(VolumetricShape... shapes) {
        return Arrays.stream(shapes)
                .map(VolumetricShape::getVolume)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    public static BigDecimal calculateAverageRadius(Round... shapes) {
        return Arrays.stream(shapes)
                .map(Round::getRadius)
                .reduce(BigDecimal::add)
                .map(sum -> sum.divide(BigDecimal.valueOf(shapes.length), RoundingMode.HALF_UP))
                .orElseThrow();
    }

    public static BigDecimal sumWeight(VolumetricShape... shapes) {
        return Arrays.stream(shapes)
                .map(VolumetricShape::getWeight)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

}
