package pl.sda.junit5.library;

import org.assertj.core.api.AbstractAssert;

public final class LibraryAssert extends AbstractAssert<LibraryAssert, Library> {

    public static LibraryAssert assertThat(Library actual) {
        return new LibraryAssert(actual);
    }

    public LibraryAssert(Library actual) {
        super(actual, LibraryAssert.class);
    }

    public void hasSize(int expectedSize) {
        if (actual.getBooks().size() != expectedSize) {
            failWithMessage("expected size %d", expectedSize);
        }
    }

}
