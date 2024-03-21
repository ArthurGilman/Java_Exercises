package core.model;

import java.time.LocalDate;

public interface IDbRecord {
    int getId();
    LocalDate getDateOfCreation();
    boolean isObsolete();
}
