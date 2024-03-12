package core.model;

import java.util.Date;

public interface DataModel {
    int getId();
    Date getDateOfCreation();
    boolean isObsolete();
}
