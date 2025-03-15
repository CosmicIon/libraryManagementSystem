class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;

    public Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addStock(int count) {
        this.quantity += count;
    }

    public boolean borrowBook() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        quantity++;
    }

    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ") - Quantity: " + quantity;
    }
}
