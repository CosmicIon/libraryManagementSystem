class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public void addUser(String name, String userId) {
        User user = new User(name, userId);
        library.registerUser(user);
    }

    public void removeUser(String userId) {
        library.removeUser(userId);
    }

    public void markUserAsDefaulter(String userId) {
        User user = library.findUserById(userId);
        if (user != null) {
            user.markAsDefaulter();
            System.out.println(user.getName() + " is now a defaulter.");
        }
    }

    public void borrowBook(String userId, String isbn) {
        User user = library.findUserById(userId);
        Book book = library.findBookByIsbn(isbn);
        if (user != null && book != null && user.borrowBook(book)) {
            System.out.println(user.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Borrowing failed.");
        }
    }

    public void returnBook(String userId, String isbn) {
        User user = library.findUserById(userId);
        Book book = library.findBookByIsbn(isbn);
        if (user != null && book != null && user.returnBook(book)) {
            System.out.println(user.getName() + " returned " + book.getTitle());
        } else {
            System.out.println("Return failed.");
        }
    }
}