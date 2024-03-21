package practice;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
public abstract class Shape implements Scalable {

    @NotNull
    private final BigDecimal area;



    Shape(@NotNull BigDecimal area) {
        this.area = area;
    }

}
