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
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUserById(int id, UserModel updatedUser) {
        UserModel user = getUserById(id);
        if (user != null) {
            user.setNombre(updatedUser.getNombre());
            user.setApellidos(updatedUser.getApellidos());
            user.setDocumento(updatedUser.getDocumento());
            user.setEdad(updatedUser.getEdad());
            user.setEmail(updatedUser.getEmail());
            user.setTelefono(updatedUser.getTelefono());
            user.setTipoCorreo(updatedUser.getTipoCorreo());
            user.setTipoTelefono(updatedUser.getTipoTelefono());
            user.setDireccion(updatedUser.getDireccion());
            user.setFechaNacimiento(updatedUser.getFechaNacimiento());
            user.setEstadoCivil(updatedUser.getEstadoCivil());
            user.setSexo(updatedUser.getSexo());
            user.setVideojuegoFavorito(updatedUser.getVideojuegoFavorito());
            user.setPeliculaFavorita(updatedUser.getPeliculaFavorita());
            user.setColorFavorito(updatedUser.getColorFavorito());
            user.setComidaFavorita(updatedUser.getComidaFavorita());
            user.setLibroFavorito(updatedUser.getLibroFavorito());
            user.setCancionFavorita(updatedUser.getCancionFavorita());
            user.setAficiones(updatedUser.getAficiones());
            user.setDescripcionPersonal(updatedUser.getDescripcionPersonal());
            return true;
        }
        return false;
    }
}





