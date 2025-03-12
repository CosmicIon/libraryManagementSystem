import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding some books to the library
        library.addBook(new Book("Java Programming", "James Gosling", "1234"));
        library.addBook(new Book("Data Structures", "Mark Weiss", "5678"));

        // Creating a user
        User user = new User("Alice", "U001");
        library.registerUser(user);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.showAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String borrowIsbn = scanner.next();
                    Book bookToBorrow = library.findBookByIsbn(borrowIsbn);
                    if (bookToBorrow != null) {
                        user.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.next();
                    Book bookToReturn = library.findBookByIsbn(returnIsbn);
                    if (bookToReturn != null) {
                        user.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
