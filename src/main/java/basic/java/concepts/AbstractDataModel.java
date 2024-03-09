package basic.java.concepts;


import lombok.Setter;

import java.util.Date;

public abstract class AbstractDataModel implements DataModel {
    private final int id;
    private final Date dateOfCreation;
    @Setter
    private boolean obsolete;

    public AbstractDataModel(int id, Date dateOfCreation, boolean obsolete) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.obsolete = obsolete;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    @Override
    public boolean isObsolete() {
        return obsolete;
    }
}
