package jvm;

import lombok.Getter;

import java.util.Objects;

@Getter
public class GoodPerson {
    private final int id;
    private final String name;
    public GoodPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodPerson that = (GoodPerson) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
