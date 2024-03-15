package core.model;

public abstract class AbstractReferenceModel extends AbstractModel implements Orderable, ReferenceData {
    private long serialNumber;
    private int referenceCode;

    public AbstractReferenceModel(int id, boolean obsolete, long serialNumber, int referenceCode) {
        super(id, obsolete);
        this.serialNumber = serialNumber;
        this.referenceCode = referenceCode;
    }
}
