import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by ID");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    id = scanner.nextLine();
                    Book bookById = library.searchBookById(id);
                    System.out.println(bookById != null ? bookById : "Book not found.");
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    Book bookByTitle = library.searchBookByTitle(title);
                    System.out.println(bookByTitle != null ? bookByTitle : "Book not found.");
                    break;
                case 4:
                    System.out.print("Enter book ID to borrow: ");
                    id = scanner.nextLine();
                    library.borrowBook(id);
                    break;
                case 5:
                    System.out.print("Enter book ID to return: ");
                    id = scanner.nextLine();
                    library.returnBook(id);
                    break;
                case 6:
                    library.displayAllBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
