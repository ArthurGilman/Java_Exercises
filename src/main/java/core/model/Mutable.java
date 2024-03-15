package core.model;

import java.time.LocalDate;
import java.util.Date;

public interface Mutable {
    LocalDate getDateOfLastModified();
    int countOfChanges();
    String getLastModifier();
}
