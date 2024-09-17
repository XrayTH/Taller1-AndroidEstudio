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
            sb.append("Correo: ").append(userModel.getEmail()).append("\n");
            sb.append("Teléfono: ").append(userModel.getTelefono()).append("\n");
            sb.append("Aficiones: ").append(userModel.getAficiones()).append("\n");
            sb.append("Sexo: ").append(userModel.getSexo()).append("\n");

            tDatos.setText(sb.toString());
        }
    }

    public void goHome(View view){
        finish();
    }
}

