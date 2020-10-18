package pl.sda.junit5.library;

import java.util.Objects;

public class Book {

    private final String author;
    private final String title;

    public Book(String aAuthor, String aTitle) {
        author = aAuthor;
        title = aTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass()) return false;
        Book book = (Book) aO;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "Book{"
                + "author='" + author + '\''
                + ", title='" + title + '\''
                + '}';
    }

}
