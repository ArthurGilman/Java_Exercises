package practice;

import java.math.BigDecimal;

class ValidationUtils {

    public static BigDecimal validateNotPositive(BigDecimal value) {
        if ((value == null) || (value.compareTo(BigDecimal.ZERO) <= 0)) {
            throw new IllegalArgumentException("Argument must be positive");
        }
        return value;
    }

    public static Integer validateNotNull(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Scale is null");
        }
        return value;
    }

}
