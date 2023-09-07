package example;


import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryInterface {
    private List<User> users;
    private List<Book> books;

    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void issueBook(User user, Book book) {
        // Implement logic to issue a book to a user
    }

    // Add other methods for library operations

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getBooks() {
        return books;
    }
}
