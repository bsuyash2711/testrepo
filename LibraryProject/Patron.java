import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String id;
    private List<Book> borrowedBooks;
    private List<Book> borrowingHistory;

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
        this.borrowingHistory = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public List<Book> getBorrowingHistory() { return borrowingHistory; }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        borrowingHistory.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
