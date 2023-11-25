package com.example.util;

import com.example.model.User;

public class UserManager {

    // Replace this method with your actual authentication logic
    public static User authenticate(String username, String password) {
        // Dummy logic, replace it with database or other authentication mechanisms
        if ("root".equals(username) && "root".equals(password)) {
            return new User(username, password);
        }
        return null;
    }
}
