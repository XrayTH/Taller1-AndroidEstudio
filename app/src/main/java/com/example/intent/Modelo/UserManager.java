package com.example.intent.Modelo;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager instance;
    private int nextId;
    private Context context;

    private UserManager(Context context) {
        this.context = context;
        this.nextId = 1; // Inicializamos el nextId en 1
        loadUsersFromFile(); // Cargamos usuarios al inicio
    }

    public static UserManager getInstance(Context context) {
        if (instance == null) {
            instance = new UserManager(context);
        }
        return instance;
    }

    public void addUser(UserModel user) {
        user.setId(nextId++);
        saveUserToFile(user);
        Toast.makeText(context, "Usuario agregado", Toast.LENGTH_SHORT).show();
    }

    public List<UserModel> getUsers() {
        return loadUsersFromFile(); // Devuelve la lista cargada
    }

    public UserModel getUserById(int id) {
        for (UserModel user : getUsers()) {
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
            saveUsersToFile();  // Guarda todos los usuarios nuevamente
            Toast.makeText(context, "Usuario actualizado", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void saveUserToFile(UserModel user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFile(), true))) {
            writer.write(userToString(user));
            writer.newLine();
        } catch (IOException e) {
            Toast.makeText(context, "Error al guardar el usuario", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveUsersToFile() {
        List<UserModel> users = getUsers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFile()))) {
            for (UserModel user : users) {
                writer.write(userToString(user));
                writer.newLine();
            }
        } catch (IOException e) {
            Toast.makeText(context, "Error al guardar los usuarios", Toast.LENGTH_SHORT).show();
        }
    }

    private List<UserModel> loadUsersFromFile() {
        List<UserModel> users = new ArrayList<>();
        File file = getFile();
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    UserModel user = stringToUser(line);
                    users.add(user);
                    // Actualizamos el nextId si el ID del usuario actual es mayor
                    if (user.getId() >= nextId) {
                        nextId = user.getId() + 1; // Asegúrate de que el siguiente ID sea uno más que el máximo
                    }
                }
            } catch (IOException e) {
                Toast.makeText(context, "Error al cargar los usuarios", Toast.LENGTH_SHORT).show();
            }
        }
        return users;
    }

    private File getFile() {
        return new File(context.getFilesDir(), "users.txt");
    }

    private String userToString(UserModel user) {
        return user.getId() + "," + user.getNombre() + "," + user.getApellidos() + "," +
                user.getDocumento() + "," + user.getEdad() + "," + user.getEmail() + "," +
                user.getTelefono() + "," + user.getTipoCorreo() + "," + user.getTipoTelefono() + "," +
                user.getDireccion() + "," + user.getFechaNacimiento() + "," + user.getEstadoCivil() + "," +
                user.getSexo() + "," + user.getVideojuegoFavorito() + "," + user.getPeliculaFavorita() + "," +
                user.getColorFavorito() + "," + user.getComidaFavorita() + "," + user.getLibroFavorito() + "," +
                user.getCancionFavorita() + "," + user.getAficiones() + "," + user.getDescripcionPersonal();
    }

    private UserModel stringToUser(String userString) {
        String[] parts = userString.split(",");
        UserModel user = new UserModel(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5],
                parts[6], parts[7], parts[8], parts[9], parts[10], parts[11], parts[12],
                parts[13], parts[14], parts[15], parts[16], parts[17], parts[18], parts[19], parts[20]);
        user.setId(Integer.parseInt(parts[0]));
        return user;
    }
}
