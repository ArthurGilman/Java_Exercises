package core.model;

import lombok.Setter;

import java.time.LocalDate;

public abstract class AbstractModel implements DataModel {
    private final int id;
    private final LocalDate dateOfCreation;

    @Setter
    private boolean obsolete;

    public AbstractModel(int id, boolean obsolete) {
        this.id = id;
        this.obsolete = obsolete;
        dateOfCreation = LocalDate.now();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    @Override
    public boolean isObsolete() {
        return obsolete;
    }

}
