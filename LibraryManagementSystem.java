import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Available Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    Book newBook = new Book(title, author, isbn);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;

                case 2: // View Books
                    library.showAvailableBooks();
                    break;

                case 3: // Borrow Book
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String borrowIsbn = scanner.next();
                    Book bookToBorrow = library.findBookByIsbn(borrowIsbn);
                    if (bookToBorrow != null) {
                        User user = new User("Alice", "U001"); // Default user for now
                        user.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4: // Return Book
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.next();
                    Book bookToReturn = library.findBookByIsbn(returnIsbn);
                    if (bookToReturn != null) {
                        User user = new User("Alice", "U001"); // Default user for now
                        user.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
