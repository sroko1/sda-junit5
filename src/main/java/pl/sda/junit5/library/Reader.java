package pl.sda.junit5.library;

import java.util.Objects;

public class Reader {

    private String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Reader reader = (Reader) object;
        return Objects.equals(name, reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
