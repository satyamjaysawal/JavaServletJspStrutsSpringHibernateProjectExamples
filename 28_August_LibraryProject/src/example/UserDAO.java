package example;



import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}
