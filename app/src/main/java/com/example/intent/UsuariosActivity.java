package com.example.intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intent.Modelo.UserManager;
import com.example.intent.Modelo.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UsuariosActivity extends AppCompatActivity {

    private ListView listViewUsuarios;
    private Button buttonRegresar;
    private List<String> userList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        listViewUsuarios = findViewById(R.id.listViewUsuarios);
        buttonRegresar = findViewById(R.id.buttonRegresar);

        UserManager userManager = UserManager.getInstance();
        List<UserModel> users = userManager.getUsers();

        userList = new ArrayList<>();
        for (UserModel user : users) {
            String userDetails = "ID: " + user.getId() + "\n" +
                    "Nombre: " + user.getNombre() + "\n" +
                    "Apellidos: " + user.getApellidos() + "\n" +
                    "Documento: " + user.getDocumento() + "\n" +
                    "Edad: " + user.getEdad() + "\n" +
                    "Email: " + user.getEmail() + "\n" +
                    "Teléfono: " + user.getTelefono() + "\n" +
                    "Tipo Teléfono: " + user.getTipoTelefono() + "\n" +
                    "Tipo Correo: " + user.getTipoCorreo() + "\n" +
                    "Dirección: " + user.getDireccion() + "\n" +
                    "Fecha de Nacimiento: " + user.getFechaNacimiento() + "\n" +
                    "Estado Civil: " + user.getEstadoCivil() + "\n" +
                    "Sexo: " + user.getSexo() + "\n" +
                    "Videojuego Favorito: " + user.getVideojuegoFavorito() + "\n" +
                    "Película Favorita: " + user.getPeliculaFavorita() + "\n" +
                    "Color Favorito: " + user.getColorFavorito() + "\n" +
                    "Comida Favorita: " + user.getComidaFavorita() + "\n" +
                    "Libro Favorito: " + user.getLibroFavorito() + "\n" +
                    "Canción Favorita: " + user.getCancionFavorita() + "\n" +
                    "Aficiones: " + user.getAficiones() + "\n" +
                    "Descripción Personal: " + user.getDescripcionPersonal() + "\n\n";
            userList.add(userDetails);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
        listViewUsuarios.setAdapter(adapter);

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}




