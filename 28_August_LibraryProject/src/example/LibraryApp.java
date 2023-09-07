package example;



public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        // Creating users
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        // Adding users to the library
        library.addUser(user1);
        library.addUser(user2);

        // Creating books
        Book book1 = new Book(101, "Introduction to Java Programming");
        Book book2 = new Book(102, "Data Structures and Algorithms");

        // Adding books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Issuing a book to a user
        library.issueBook(user1, book1);

        // Displaying user and book information
        System.out.println("Users in the library:");
        System.out.println(user1);
        System.out.println(user2);

        System.out.println("\nBooks in the library:");
        System.out.println(book1);
        System.out.println(book2);
    }
}
