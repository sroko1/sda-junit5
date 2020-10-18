package pl.sda.junit5.library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.unmodifiableList;

public class Library {

    private final List<Book> books = new LinkedList<>();
    private final Map<Reader, Set<Book>> readersBooks = new HashMap<>();

    public List<Book> getBooks() {
        return unmodifiableList(books);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean hasBook(Book book) {
        return books.contains(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public boolean borrowBook(Book book, Reader reader) {
        if (books.contains(book) && !isBorrowedBook(book)) {
            Set<Book> readerBooks = readersBooks.getOrDefault(reader, new HashSet<>());
            readerBooks.add(book);
            readersBooks.put(reader, readerBooks);
            return true;
        } else {
            return false;
        }
    }

    public boolean isBorrowedBook(Book book) {
        for (Set<Book> readerBooks : readersBooks.values()) {
            if (readerBooks.contains(book)) {
                return true;
            }
        }
        return false;
    }

}
