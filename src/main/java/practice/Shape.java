package practice;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
public abstract class Shape implements Scalable {

    private final BigDecimal area;
    private int scale;



    Shape(@NotNull BigDecimal area, int scale) {
        this.area = area;
        this.scale = scale;
    }

    @Override
    public int getScale() {
        return scale;
    }
}
