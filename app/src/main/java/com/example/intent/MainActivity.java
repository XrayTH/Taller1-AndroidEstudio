package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellidos;
    private EditText editTextEmail;
    private EditText editTextTelefono;
    private CheckBox cb1, cb2, cb3, cb4;
    private RadioButton rb1, rb2;
    Spinner spin;
    String [] listTelefono = {"casa", "personal", "trabajo", "emergencia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        spin = findViewById(R.id.spinner);
        ArrayAdapter <String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listTelefono);
        spin.setAdapter(adaptador);
    }

    public void enviarDatos(View view) {
        String cadena = "";
        if(cb1.isChecked()){
            cadena += "Música";
        }

        if(cb2.isChecked()){
            if(!cadena.isEmpty()){
                cadena += ", ";
            }
            cadena += "Deporte";
        }

        if(cb3.isChecked()){
            if(!cadena.isEmpty()){
                cadena += ", ";
            }
            cadena += "Cine";
        }

        if(cb4.isChecked()){
            if(!cadena.isEmpty()){
                cadena += ", ";
            }
            cadena += "Videojuegos";
        }

        String sexo = "";

        if(rb1.isChecked()){
            sexo = "Masculino";
        }else{
            sexo = "femenino";
        }

        String nombre = editTextNombre.getText().toString();
        String apellidos = editTextApellidos.getText().toString();
        String email = editTextEmail.getText().toString();
        String telefono = editTextTelefono.getText().toString();

        String[] datosUsuario = {nombre, apellidos, email, telefono, sexo};

        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);

        intent.putExtra("datosUsuario", datosUsuario);
        intent.putExtra("Aficiones", cadena);

        startActivity(intent);
    }
}
