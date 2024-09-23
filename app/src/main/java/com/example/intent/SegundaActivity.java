package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intent.Modelo.UserModel;

public class SegundaActivity extends AppCompatActivity {

    private TextView tDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tDatos = findViewById(R.id.textViewDatos);

        UserModel userModel = (UserModel) getIntent().getSerializableExtra("userModel");

        if (userModel != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ").append(userModel.getNombre()).append("\n");
            sb.append("Apellidos: ").append(userModel.getApellidos()).append("\n");
            sb.append("Documento: ").append(userModel.getDocumento()).append("\n");
            sb.append("Edad: ").append(userModel.getEdad()).append("\n");
            sb.append("Correo: ").append(userModel.getEmail()).append("\n");
            sb.append("Tipo Correo: ").append(userModel.getTipoCorreo()).append("\n");
            sb.append("Teléfono: ").append(userModel.getTelefono()).append("\n");
            sb.append("Tipo Teléfono: ").append(userModel.getTipoTelefono()).append("\n");
            sb.append("Dirección: ").append(userModel.getDireccion()).append("\n");
            sb.append("Fecha de Nacimiento: ").append(userModel.getFechaNacimiento()).append("\n");
            sb.append("Estado Civil: ").append(userModel.getEstadoCivil()).append("\n");
            sb.append("Sexo: ").append(userModel.getSexo()).append("\n");
            sb.append("Videojuego Favorito: ").append(userModel.getVideojuegoFavorito()).append("\n");
            sb.append("Película Favorita: ").append(userModel.getPeliculaFavorita()).append("\n");
            sb.append("Color Favorito: ").append(userModel.getColorFavorito()).append("\n");
            sb.append("Comida Favorita: ").append(userModel.getComidaFavorita()).append("\n");
            sb.append("Libro Favorito: ").append(userModel.getLibroFavorito()).append("\n");
            sb.append("Canción Favorita: ").append(userModel.getCancionFavorita()).append("\n");
            sb.append("Aficiones: ").append(userModel.getAficiones()).append("\n");
            sb.append("Descripción Personal: ").append(userModel.getDescripcionPersonal()).append("\n");

            tDatos.setText(sb.toString());
        }
    }

    public void goHome(View view){
        finish();
    }
}

