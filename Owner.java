class Owner {
    private Library library;

    public Owner(Library library) {
        this.library = library;
    }

    public void addBook(String title, String author, String isbn, int quantity) {
        Book book = new Book(title, author, isbn, quantity);
        library.addBook(book);
    }

    public void removeBook(String isbn) {
        library.removeBook(isbn);
    }
}