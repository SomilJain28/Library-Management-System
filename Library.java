import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book searchBookById(String id) {
        return books.get(id);
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String id) {
        Book book = books.get(id);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            System.out.println("You have successfully borrowed: " + book.getTitle());
        } else if (book == null) {
            System.out.println("Book not found!");
        } else {
            System.out.println("Book is already borrowed!");
        }
    }

    public void returnBook(String id) {
        Book book = books.get(id);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            System.out.println("You have successfully returned: " + book.getTitle());
        } else if (book == null) {
            System.out.println("Book not found!");
        } else {
            System.out.println("Book is not borrowed!");
        }
    }

    public void displayAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}
