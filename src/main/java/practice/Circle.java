package practice;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Circle extends FlatShape implements Round {

    private final BigDecimal radius;

    public Circle(@NotNull BigDecimal radius, int scale) {
        super(radius.pow(2).multiply(BigDecimalUtils.PI),
                radius.multiply(BigDecimalUtils.PI).multiply(BigDecimal.TWO), scale);
        this.radius = radius;
    }

    @Override
    public BigDecimal getRadius() {
        return radius;
    }
}
