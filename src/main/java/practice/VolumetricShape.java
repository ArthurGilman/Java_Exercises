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
        if (volume.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Volume of Volumetric Shape can't be negative");
        if (weight.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Weight of Volumetric Shape can't be negative");
        this.volume = volume;
        this.weight = weight;
    }

}
