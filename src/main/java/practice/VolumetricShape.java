package practice;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
public abstract class VolumetricShape extends Shape {
    private final BigDecimal volume;
    private final BigDecimal weight;

    public VolumetricShape(@NotNull BigDecimal area, BigDecimal volume, BigDecimal weight, Integer scale) {
        super(area, scale);
        this.volume = ValidationUtils.validateNotPositive(volume);
        this.weight = ValidationUtils.validateNotPositive(weight);
    }

}
