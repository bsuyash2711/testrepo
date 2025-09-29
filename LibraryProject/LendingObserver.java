public interface LendingObserver {
    void onBookLent(Book book, Patron patron);
    void onBookReturned(Book book, Patron patron);
}
