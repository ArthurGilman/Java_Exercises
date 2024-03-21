package practice;

import lombok.Getter;

import java.math.BigDecimal;


@Getter
public abstract class FlatShape extends Shape {
    private final BigDecimal perimeter;

    public FlatShape(BigDecimal area, BigDecimal perimeter) {
        super(area);
        this.perimeter = perimeter;
    }

}
