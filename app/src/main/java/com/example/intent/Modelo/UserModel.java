package com.example.intent.Modelo;

import java.io.Serializable;

public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int nextId = 1;

    private int id;
    private String nombre;
    private String apellidos;
    private String documento;
    private int edad;
    private String email;
    private String tipoCorreo;
    private String telefono;
    private String tipoTelefono;
    private String direccion;
    private String fechaNacimiento;
    private String estadoCivil;
    private String sexo;
    private String videojuegoFavorito;
    private String peliculaFavorita;
    private String colorFavorito;
    private String comidaFavorita;
    private String libroFavorito;
    private String cancionFavorita;
    private String aficiones;
    private String descripcionPersonal;

    public UserModel(String nombre, String apellidos, String documento, int edad, String email, String telefono, String tipoCorreo,
                     String tipoTelefono, String direccion, String fechaNacimiento, String estadoCivil, String sexo,
                     String videojuegoFavorito, String peliculaFavorita, String colorFavorito, String comidaFavorita,
                     String libroFavorito, String cancionFavorita, String aficiones, String descripcionPersonal) {
        this.id = nextId++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.tipoTelefono = tipoTelefono;
        this.tipoCorreo = tipoCorreo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.videojuegoFavorito = videojuegoFavorito;
        this.peliculaFavorita = peliculaFavorita;
        this.colorFavorito = colorFavorito;
        this.comidaFavorita = comidaFavorita;
        this.libroFavorito = libroFavorito;
        this.cancionFavorita = cancionFavorita;
        this.aficiones = aficiones;
        this.descripcionPersonal = descripcionPersonal;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipoCorreo() {return tipoCorreo;}
    public void setTipoCorreo(String tipoCorreo) {this.tipoCorreo = tipoCorreo;}

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTipoTelefono() { return tipoTelefono; }
    public void setTipoTelefono(String tipoTelefono) { this.tipoTelefono = tipoTelefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getVideojuegoFavorito() { return videojuegoFavorito; }
    public void setVideojuegoFavorito(String videojuegoFavorito) { this.videojuegoFavorito = videojuegoFavorito; }

    public String getPeliculaFavorita() { return peliculaFavorita; }
    public void setPeliculaFavorita(String peliculaFavorita) { this.peliculaFavorita = peliculaFavorita; }

    public String getColorFavorito() { return colorFavorito; }
    public void setColorFavorito(String colorFavorito) { this.colorFavorito = colorFavorito; }

    public String getComidaFavorita() { return comidaFavorita; }
    public void setComidaFavorita(String comidaFavorita) { this.comidaFavorita = comidaFavorita; }

    public String getLibroFavorito() { return libroFavorito; }
    public void setLibroFavorito(String libroFavorito) { this.libroFavorito = libroFavorito; }

    public String getCancionFavorita() { return cancionFavorita; }
    public void setCancionFavorita(String cancionFavorita) { this.cancionFavorita = cancionFavorita; }

    public String getAficiones() { return aficiones; }
    public void setAficiones(String aficiones) { this.aficiones = aficiones; }

    public String getDescripcionPersonal() { return descripcionPersonal; }
    public void setDescripcionPersonal(String descripcionPersonal) { this.descripcionPersonal = descripcionPersonal; }
}
