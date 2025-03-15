import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String userId;
    private boolean isDefaulter;
    private List<Book> borrowedBooks;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.isDefaulter = false;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isDefaulter() {
        return isDefaulter;
    }

    public void markAsDefaulter() {
        this.isDefaulter = true;
    }

    public void removeDefaulterStatus() {
        this.isDefaulter = false;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(Book book) {
        if (!isDefaulter && book.borrowBook()) {
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            return true;
        }
        return false;
    }
}
