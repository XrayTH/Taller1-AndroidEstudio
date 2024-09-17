package com.example.intent.Modelo;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String sexo;
    private String aficiones;

    public UserModel(String nombre, String apellidos, String email, String telefono, String sexo, String aficiones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.sexo = sexo;
        this.aficiones = aficiones;
    }

    // Getters and setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getAficiones() { return aficiones; }
    public void setAficiones(String aficiones) { this.aficiones = aficiones; }
}

