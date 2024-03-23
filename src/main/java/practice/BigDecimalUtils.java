package practice;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

public class BigDecimalUtils {
    public static final BigDecimal PI = BigDecimal.valueOf(3.14159);

    public static @NotNull BigDecimal sumArea(@Nullable Shape... shapes) {
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(Shape::getArea)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    public static @NotNull BigDecimal sumPerimeter(@Nullable FlatShape... shapes) {
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(FlatShape::getPerimeter)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }



    public static @NotNull BigDecimal sumVolume(@Nullable VolumetricShape... shapes) {
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(VolumetricShape::getVolume)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    public static @NotNull BigDecimal calculateAverageRadius(@Nullable Round... shapes) {
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(Round::getRadius)
                .reduce(BigDecimal::add)
                .map(sum -> sum.divide(BigDecimal.valueOf(shapes.length), RoundingMode.HALF_UP))
                .orElseThrow();
    }

    public static @NotNull BigDecimal sumWeight(@Nullable VolumetricShape... shapes) {
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(VolumetricShape::getWeight)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

}
