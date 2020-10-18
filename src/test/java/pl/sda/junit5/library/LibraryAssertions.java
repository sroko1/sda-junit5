package pl.sda.junit5.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LibraryAssertions {

    private LibraryAssertions() {
    }

    public static void assertSize(int expectedSize, Library library) {
        assertEquals(expectedSize, library.getBooks().size());
    }

}
