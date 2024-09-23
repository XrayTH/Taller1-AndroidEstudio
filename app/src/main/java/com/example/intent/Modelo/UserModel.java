package com.example.intent.Modelo;

import java.io.Serializable;

public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int nextId = 1;

    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String tipoCorreo;
    private String telefono;
    private String tipoTelefono;
    private String sexo;
    private String aficiones;

    public UserModel(String nombre, String apellidos, String email, String telefono, String tipoTelefono, String tipoCorreo, String sexo, String aficiones) {
        this.id = nextId++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tipoCorreo = tipoCorreo;
        this.telefono = telefono;
        this.tipoTelefono = tipoTelefono;
        this.sexo = sexo;
        this.aficiones = aficiones;
    }

    //Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipoCorreo() { return tipoCorreo; }
    public void setTipoCorreo(String tipoCorreo) { this.tipoCorreo = tipoCorreo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTipoTelefono() { return tipoTelefono; }
    public void setTipoTelefono(String tipoTelefono) { this.tipoTelefono = tipoTelefono; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getAficiones() { return aficiones; }
    public void setAficiones(String aficiones) { this.aficiones = aficiones; }
}

