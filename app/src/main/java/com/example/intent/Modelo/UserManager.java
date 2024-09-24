package com.example.intent.Modelo;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager instance;
    private List<UserModel> users;
    private int nextId;

    private UserManager() {
        users = new ArrayList<>();
        nextId = 1;
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(UserModel user) {
        user.setId(nextId++);
        users.add(user);
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public UserModel getUserById(int id) {
        for (UserModel user : users) {
            // Comparamos el ID del usuario (que es int) con el ID ingresado
            if (user.getId() == id) {
                return user;
            }
        }
        return null;  // Si no se encuentra el usuario
    }
}



