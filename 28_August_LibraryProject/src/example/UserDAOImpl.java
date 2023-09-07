package example;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    private Map<Integer, User> userMap; // Simulating a database or storage

    public UserDAOImpl() {
        userMap = new HashMap<>();
    }

    @Override
    public void saveUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUser(int id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
