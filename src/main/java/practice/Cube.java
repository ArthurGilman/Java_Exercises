package practice;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Cube extends VolumetricShape {
    private final BigDecimal side;

    public Cube(@NotNull BigDecimal side, BigDecimal weight, Integer scale) {
        super(ValidationUtils.validateNotPositive(side).pow(2).multiply(BigDecimal.valueOf(6)),
                ValidationUtils.validateNotPositive(side).pow(3),
                weight, scale);
        this.side = side;
    }
}
