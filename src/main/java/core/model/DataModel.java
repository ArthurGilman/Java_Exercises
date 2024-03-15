package core.model;

import java.time.LocalDate;

public interface DataModel {
    int getId();
    LocalDate getDateOfCreation();
    boolean isObsolete();
}
