package practice;

import java.math.BigDecimal;

public class Circle extends FlatShape implements Round {

    private final BigDecimal radius;

    Circle(BigDecimal radius) {
        super(radius.pow(2).multiply(BigDecimalUtils.PI),
                radius.multiply(BigDecimalUtils.PI).multiply(BigDecimal.TWO));
        this.radius = radius;
    }

    @Override
    public BigDecimal getRadius() {
        return radius;
    }
}
