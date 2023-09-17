package com.example;

import java.sql.SQLException;
import java.util.List;

public interface UserDAOInterface {
    void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUsers();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> searchUsersByName(String name);
}
