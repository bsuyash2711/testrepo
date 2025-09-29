import java.util.*;
import java.util.stream.Collectors;

public class LibraryInventory {
    private Map<String, Book> books;

    public LibraryInventory() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void updateBook(String isbn, Book updatedBook) {
        if (books.containsKey(isbn)) {
            books.put(isbn, updatedBook);
        }
    }

    public Book searchByIsbn(String isbn) {
        return books.get(isbn);
    }

    public Book searchByTitle(String title) {
        return books.values().stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(title))
            .findFirst().orElse(null);
    }

    public Book searchByAuthor(String author) {
        return books.values().stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .findFirst().orElse(null);
    }

    public List<Book> getAvailableBooks() {
        return books.values().stream()
            .filter(Book::isAvailable)
            .collect(Collectors.toList());
    }

    public List<Book> getBorrowedBooks() {
        return books.values().stream()
            .filter(book -> !book.isAvailable())
            .collect(Collectors.toList());
    }

    public Map<String, Book> getBooks() {
        return books;
    }
}
