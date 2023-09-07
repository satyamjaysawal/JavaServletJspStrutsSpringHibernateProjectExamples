package example;


import java.util.Map;
import java.util.HashMap;

public class BookDAOImpl implements BookDAO {
    private Map<Integer, Book> bookMap; // Simulating a database or storage

    public BookDAOImpl() {
        bookMap = new HashMap<>();
    }

    @Override
    public void saveBook(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public Book getBook(int id) {
        return bookMap.get(id);
    }
}
