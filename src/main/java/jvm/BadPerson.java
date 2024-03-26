package jvm;

import lombok.Getter;

@Getter
public class BadPerson {
    private final int id;
    private final String name;
    public BadPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public boolean equals(Object obj) {
        BadPerson p = (BadPerson) obj;
        if (id != p.id) return false;
        return name.equals(p.name);
    }
}
