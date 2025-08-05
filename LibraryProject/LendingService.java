import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LendingService {
    private static final Logger logger = Logger.getLogger(LendingService.class.getName());
    private LibraryInventory inventory;
    private List<LendingObserver> observers = new ArrayList<>();

    public LendingService(LibraryInventory inventory) {
        this.inventory = inventory;
    }

    public void addObserver(LendingObserver observer) {
        observers.add(observer);
    }

    private void notifyLent(Book book, Patron patron) {
        for (LendingObserver observer : observers) {
            observer.onBookLent(book, patron);
        }
    }

    private void notifyReturned(Book book, Patron patron) {
        for (LendingObserver observer : observers) {
            observer.onBookReturned(book, patron);
        }
    }

    public boolean checkoutBook(Patron patron, String isbn) {
        Book book = inventory.searchByIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            patron.borrowBook(book);
            logger.info("Book checked out: " + book);
            notifyLent(book, patron);
            return true;
        }
        logger.warning("Book not available for checkout: " + isbn);
        return false;
    }

    public boolean returnBook(Patron patron, String isbn) {
        Book book = inventory.searchByIsbn(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            patron.returnBook(book);
            logger.info("Book returned: " + book);
            notifyReturned(book, patron);
            return true;
        }
        logger.warning("Book not found or already returned: " + isbn);
        return false;
    }
}
