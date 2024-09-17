package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intent.Modelo.UserModel;
import com.example.intent.Modelo.UserManager;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellidos;
    private EditText editTextEmail;
    private EditText editTextTelefono;
    private CheckBox cb1, cb2, cb3, cb4;
    private RadioButton rb1, rb2;
    Spinner spin, spin2;

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
        spin2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{
                "Casa", "Personal", "Trabajo", "Emergencia"
        });
        spin.setAdapter(adaptador);
        spin2.setAdapter(adaptador);
    }

    public void enviarDatos(View view) {
        String aficiones = "";
        if (cb1.isChecked()) aficiones += "Música";
        if (cb2.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Deporte";
        if (cb3.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Cine";
        if (cb4.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Videojuegos";

        String sexo = rb1.isChecked() ? "Masculino" : "Femenino";
        String nombre = editTextNombre.getText().toString();
        String apellidos = editTextApellidos.getText().toString();
        String email = editTextEmail.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String tipoTelefono = spin.getSelectedItem().toString();
        String tipoCorreo = spin2.getSelectedItem().toString();

        UserModel userModel = new UserModel(nombre, apellidos, email, telefono, tipoTelefono, tipoCorreo, sexo, aficiones);

        UserManager.getInstance().addUser(userModel);

        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        intent.putExtra("userModel", userModel);
        startActivity(intent);
    }
}


