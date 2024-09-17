package com.example.intent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {

    private TextView tDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tDatos = findViewById(R.id.textViewDatos);

        String[] datosUsuario = getIntent().getStringArrayExtra("datosUsuario");
        String selecciones = getIntent().getStringExtra("Aficiones");

        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(datosUsuario[0]).append("\n");
        sb.append("Apellidos: ").append(datosUsuario[1]).append("\n");
        sb.append("Correo: ").append(datosUsuario[2]).append("\n");
        sb.append("Teléfono: ").append(datosUsuario[3]).append("\n");
        sb.append("Aficiones: ").append(selecciones).append("\n");
        sb.append("Sexo: ").append(datosUsuario[4]).append("\n");

        tDatos.setText(sb.toString());
    }

    public void goHome(View view){
        finish();
    }
}
