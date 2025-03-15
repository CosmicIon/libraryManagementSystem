import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Owner owner = new Owner(library);
        Librarian librarian = new Librarian(library);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose Role: 1. Owner  2. Librarian  3. Exit");
            int role = scanner.nextInt();

            if (role == 1) { // Owner Menu
                System.out.println("1. Add Book  2. Remove Book");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Title: "); String title = scanner.nextLine();
                    System.out.print("Author: "); String author = scanner.nextLine();
                    System.out.print("ISBN: "); String isbn = scanner.nextLine();
                    System.out.print("Quantity: "); int qty = scanner.nextInt();
                    owner.addBook(title, author, isbn, qty);
                } else if (choice == 2) {
                    System.out.print("Enter ISBN: ");
                    owner.removeBook(scanner.next());
                }
            }

            else if (role == 2) { // Librarian Menu
                System.out.println("1. Add User  2. Borrow Book  3. Return Book  4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    System.out.print("User Name: "); String name = scanner.nextLine();
                    System.out.print("User ID: "); String id = scanner.next();
                    librarian.addUser(name, id);
                }
            }

            else break;
        }
        scanner.close();
    }
}
