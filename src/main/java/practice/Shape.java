package practice;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;


public abstract class Shape implements Scalable, Comparable<Shape> {

    @Getter
    private final BigDecimal area;
    private Integer scale;



    Shape(@NotNull BigDecimal area, Integer scale) {
        if (area.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Area can't be negative");
        this.area = area;
        this.scale = scale;
    }

    @Override
    public Integer getScale() {
        return scale;
    }

    @Override
    public int compareTo(@NotNull Shape o) {
        if (area.doubleValue() - o.getArea().doubleValue() > 0) return 1;
        else if (area.doubleValue() - o.getArea().doubleValue() == 0) return 0;
        return -1;
    }
}
