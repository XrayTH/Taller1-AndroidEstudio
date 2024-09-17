package com.example.intent.Modelo;

import java.util.ArrayList;

public class UserManager {
    private static UserManager instance;
    private ArrayList<UserModel> userList;

    private UserManager() {
        userList = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(UserModel user) {
        userList.add(user);
    }

    public ArrayList<UserModel> getUserList() {
        return userList;
    }
}

