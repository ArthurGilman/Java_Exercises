package basic.java.concepts;

import java.util.Date;

public interface Mutable {
    Date getDateOfLastModified();
    int countOfChanges();
    String getLastModifier();
}
