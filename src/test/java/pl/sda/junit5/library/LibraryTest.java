package pl.sda.junit5.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.sda.junit5.library.LibraryAssert.assertThat;
import static pl.sda.junit5.library.LibraryAssertions.assertSize;

class LibraryTest {

    private static final Book BOOK_1 = new Book("Bolesław Prus", "Lalka");
    private static final Book BOOK_2 = new Book("Stanisław Wyspiański", "Wesele");
    private static final Book BOOK_3 = new Book("Witold Gombrowicz", "Ferdydurke");
    private static final Book BOOK_4 = new Book("Bruno Schulz", "Sklepy cynamonowe");

    private final Library library = new Library();

    @BeforeEach
    void setUp() {
        library.addBook(BOOK_1);
        library.addBook(BOOK_2);
        library.addBook(BOOK_3);
        library.addBook(BOOK_4);
    }

    @Test
    void shouldReturnListWithBooksWhenLibraryWasInitialized() {
        // then
        assertSize(4, library);
        assertThat(library).hasSize(4);
    }

    @Test
    void shouldReturnListWithNewBookWhenBookWasAdded() {
        // given
        Book book = new Book("Henryk Sienkiewicz", "W pustyni i w puszczy");
        // when
        library.addBook(book);
        // then
        assertEquals(asList(BOOK_1, BOOK_2, BOOK_3, BOOK_4, book), library.getBooks());
        assertThat(library.getBooks()).containsExactly(BOOK_1, BOOK_2, BOOK_3, BOOK_4, book);
    }

    @Test
    void shouldFoundBookWhenBookExists() {
        // when
        boolean result = library.hasBook(BOOK_1);
        // then
        assertTrue(result);
        assertThat(result).isTrue();
    }

    @Test
    void shouldNotFoundBookWhenBookIsNotExist() {
        // given
        Book book = new Book("Henryk Sienkiewicz", "W pustyni i w puszczy");
        // when
        boolean result = library.hasBook(book);
        // then
        assertFalse(result);
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnListWithoutOneBookWhenBookWasRemoved() {
        // when
        library.removeBook(BOOK_4);
        // then
        assertEquals(asList(BOOK_1, BOOK_2, BOOK_3), library.getBooks());
        assertThat(library.getBooks()).containsExactly(BOOK_1, BOOK_2, BOOK_3);
    }

    @Test
    void shouldBorrowBookWhenIsAvailable() {
        // given
        Reader reader = new Reader("Jan Kowalski");
        // when
        boolean result = library.borrowBook(BOOK_1, reader);
        // then
        assertTrue(result);
        assertThat(result).isTrue();
    }

    @Test
    void shouldBookBeBorrowedWhenReaderBorrowBook() {
        // given
        Reader reader = new Reader("Jan Kowalski");
        library.borrowBook(BOOK_1, reader);
        // when
        boolean result = library.isBorrowedBook(BOOK_1);
        // then
        assertTrue(result);
        assertThat(result).isTrue();
    }

    @Test
    void shouldBookBeNotBorrowedWhenReaderBorrowAnotherBook() {
        // given
        Reader reader = new Reader("Jan Kowalski");
        library.borrowBook(BOOK_2, reader);
        // when
        boolean result = library.isBorrowedBook(BOOK_1);
        // then
        assertFalse(result);
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBorrowBookWhenBookIsNotExist() {
        // given
        Book book = new Book("Henryk Sienkiewicz", "W pustyni i w puszczy");
        Reader reader = new Reader("Jan Kowalski");
        // when
        boolean result = library.borrowBook(book, reader);
        // then
        assertFalse(result);
        assertThat(result).isFalse();
    }

    @Test
    void shouldNotBorrowBookWhenBookIsBorrowed() {
        // given
        Reader reader = new Reader("Jan Kowalski");
        library.borrowBook(BOOK_1, reader);
        // when
        boolean result = library.borrowBook(BOOK_1, reader);
        // then
        assertFalse(result);
        assertThat(result).isFalse();
    }

}
