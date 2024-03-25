package practice;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;


@Getter
public abstract class FlatShape extends Shape {
    private final BigDecimal perimeter;

    public FlatShape(@NotNull BigDecimal area, BigDecimal perimeter, Integer scale) {
        super(area, scale);
        if (perimeter.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Perimeter of Flat Shape can't be negative");
        this.perimeter = perimeter;
    }

}
