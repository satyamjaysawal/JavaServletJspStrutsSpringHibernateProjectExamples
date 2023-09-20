package com.example;

import java.util.List;

public interface UserDAOInterface {
    void insertUser(User user);
    User selectUser(int id);
    List<User> selectAllUsers();
    boolean deleteUser(int id);
    boolean updateUser(User user);
    List<User> searchUsersByName(String name);
}
