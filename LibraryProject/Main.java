import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryInventory inventory = new LibraryInventory();
        LendingService lendingService = new LendingService(inventory);
        List<Patron> patrons = new ArrayList<>();

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Search book by title");
            System.out.println("3. Checkout book");
            System.out.println("4. Return book");
            System.out.println("5. View available books");
            System.out.println("6. View borrowed books");
            System.out.println("7. Add new patron");
            System.out.println("8. Update patron information");
            System.out.println("9. Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter book details:");
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Publication Year: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    Book book = BookFactory.createBook(title, author, isbn, year);
                    inventory.addBook(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = inventory.searchByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter patron ID: ");
                    String patronIdCheckout = scanner.nextLine();
                    Patron patronCheckout = findPatronById(patrons, patronIdCheckout);
                    if (patronCheckout != null) {
                        System.out.print("Enter ISBN to checkout: ");
                        String checkoutIsbn = scanner.nextLine();
                        lendingService.checkoutBook(patronCheckout, checkoutIsbn);
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter patron ID: ");
                    String patronIdReturn = scanner.nextLine();
                    Patron patronReturn = findPatronById(patrons, patronIdReturn);
                    if (patronReturn != null) {
                        System.out.print("Enter ISBN to return: ");
                        String returnIsbn = scanner.nextLine();
                        lendingService.returnBook(patronReturn, returnIsbn);
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;

                case 5:
                    System.out.println("Available Books:");
                    for (Book b : inventory.getAvailableBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 6:
                    System.out.println("Borrowed Books:");
                    for (Book b : inventory.getBorrowedBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 7:
                    System.out.print("Enter new patron name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new patron ID: ");
                    String newId = scanner.nextLine();
                    Patron newPatron = new Patron(newName, newId);
                    patrons.add(newPatron);
                    System.out.println("New patron added successfully!");
                    break;

                case 8:
                    System.out.print("Enter patron ID to update: ");
                    String updateId = scanner.nextLine();
                    Patron foundPatron = findPatronById(patrons, updateId);
                    if (foundPatron != null) {
                        System.out.print("Enter new name: ");
                        String updatedName = scanner.nextLine();
                        foundPatron.setName(updatedName);
                        System.out.println("Patron information updated.");
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;

                case 9:
                    System.out.println("Thank you for using the Library Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static Patron findPatronById(List<Patron> patrons, String id) {
        for (Patron p : patrons) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}

