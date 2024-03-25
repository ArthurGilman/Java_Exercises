package practice;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Parallelogram extends FlatShape {
    private final BigDecimal base; // Основание: __
    private final BigDecimal height; // Высота: |
    private final BigDecimal side; // Боковая грань: /

    public Parallelogram(@NotNull BigDecimal base, BigDecimal height, BigDecimal side, Integer scale) {
        super(base.multiply(height),
                base.add(side).multiply(BigDecimal.TWO), scale);
        if (side.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Side of Parallelogram can't be negative");
        this.base = base;
        this.height = height;
        this.side = side;
    }
}
