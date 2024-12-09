package com.example.metaauth.storage;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private static final Map<String, String> users = new HashMap<>();

    static {
        // Usuarios predefinidos
        users.put("user1@meta.com", "password1");
        users.put("user2@meta.com", "password2");
    }

    public static boolean isEmailRegistered(String email) {
        return users.containsKey(email);
    }

    public static boolean validateCredentials(String email, String password) {
        return users.getOrDefault(email, "").equals(password);
    }
}
