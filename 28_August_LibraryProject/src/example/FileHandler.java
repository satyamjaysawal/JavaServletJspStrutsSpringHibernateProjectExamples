package example;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String usersFilePath = "C:\\Users\\sjaysawa\\Desktop\\Filestream\\OneFile.txt";
    private String booksFilePath = "C:\\Users\\sjaysawa\\Desktop\\Filestream\\TwoFile.txt";

    public List<User> readUsersFromFile() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                users.add(new User(id, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Book> readBooksFromFile() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(booksFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                books.add(new Book(id, title));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void writeUsersToFile(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFilePath))) {
            for (User user : users) {
                writer.write(user.getId() + "," + user.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBooksToFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(booksFilePath))) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
