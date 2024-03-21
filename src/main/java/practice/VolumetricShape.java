package practice;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public abstract class VolumetricShape extends Shape {
    private final BigDecimal volume;
    private final BigDecimal weight;

    public VolumetricShape(BigDecimal area, BigDecimal volume, BigDecimal weight) {
        super(area);
        this.volume = volume;
        this.weight = weight;
    }

}
