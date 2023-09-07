package example;


import java.util.HashMap;
import java.util.Map;

public interface BookDAO {
    void saveBook(Book book);
    Book getBook(int id);
}

