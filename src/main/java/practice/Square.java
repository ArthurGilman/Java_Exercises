package practice;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Square extends Parallelogram {
    public Square(@NotNull BigDecimal side, int scale) {
        super(side, side, side, scale);
    }
}
