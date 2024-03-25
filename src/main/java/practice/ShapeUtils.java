package practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;


public class ShapeUtils {
    private static final Logger logger = LogManager.getLogger(ShapeUtils.class);
    public static final BigDecimal PI = BigDecimal.valueOf(3.14159);


    /**
     * @param shapes Represents arguments that implement an interface Shape
     * @return the sum of the area of shapes
     */
    public static @NotNull BigDecimal sumArea(@Nullable Shape... shapes) {
        logger.debug("Sum Area calculating");
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(Shape::getArea)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    /**
     * @param shapes Represents arguments that implement an interface FlatShape
     * @return the sum of the perimeter of shapes
     */
    public static @NotNull BigDecimal sumPerimeter(@Nullable FlatShape... shapes) {
        logger.debug("Sum Perimeter calculating");
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(FlatShape::getPerimeter)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }


    /**
     * @param shapes Represents arguments that implement an interface VolumetricShape
     * @return the sum of the volume of shapes
     */
    public static @NotNull BigDecimal sumVolume(@Nullable VolumetricShape... shapes) {
        logger.debug("Sum volume calculating");
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(VolumetricShape::getVolume)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

    /**
     * @param shapes Represents arguments that implement an interface Round
     * @return the average radius of shapes
     */
    public static @NotNull BigDecimal calculateAverageRadius(@Nullable Round... shapes) {
        logger.debug("calculating average radius");
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(Round::getRadius)
                .reduce(BigDecimal::add)
                .map(sum -> sum.divide(BigDecimal.valueOf(shapes.length), RoundingMode.HALF_UP))
                .orElseThrow();
    }

    /**
     * @param shapes Represents arguments that implement an interface VolumetricShape
     * @return  the sum of the weight of shapes
     */
    public static @NotNull BigDecimal sumWeight(@Nullable VolumetricShape... shapes) {
        logger.debug("sum weight calculating");
        return Arrays.stream(shapes)
                .filter(Objects::nonNull)
                .map(VolumetricShape::getWeight)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

}
