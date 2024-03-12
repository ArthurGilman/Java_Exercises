package core.model;

import java.util.Date;

public interface Mutable {
    Date getDateOfLastModified();
    int countOfChanges();
    String getLastModifier();
}
