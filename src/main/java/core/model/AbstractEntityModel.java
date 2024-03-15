package core.model;

import java.time.LocalDate;

public abstract class AbstractEntityModel extends AbstractModel implements Mutable {

    private LocalDate dateOfLastModified;
    private int countChanges;
    private String lastModifier;

    public AbstractEntityModel(int id, boolean obsolete) {
        super(id, obsolete);
        this.countChanges = 0;
        lastModifier = "";
        dateOfLastModified = super.getDateOfCreation();
    }



    @Override
    public LocalDate getDateOfLastModified() {
        return dateOfLastModified;
    }

    @Override
    public int countOfChanges() {
        return countChanges;
    }

    @Override
    public String getLastModifier() {
        return lastModifier;
    }

}
