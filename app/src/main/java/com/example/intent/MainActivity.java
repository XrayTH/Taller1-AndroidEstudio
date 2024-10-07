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

    private EditText editTextNombre, editTextApellidos, editTextDocumento, editTextEdad, editTextEmail, editTextTelefono;
    private EditText editTextDireccion, editTextFechaNacimiento, editTextPeliculaFavorita, editTextColorFavorito;
    private EditText editTextComidaFavorita, editTextLibroFavorito, editTextCancionFavorita, editTextDescripcionPersonal;
    private CheckBox checkBoxComida, checkBoxMusica, checkBoxDeporte, checkBoxCine, checkBoxVideojuegos, checkBoxViajes, checkBoxLibros;
    private RadioButton radioButtonMasculino, radioButtonFemenino, radioButtonCasado, radioButtonSoltero;
    private Spinner spinnerTipoTelefono, spinnerTipoCorreo, spinnerVideojuegoFavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextDocumento = findViewById(R.id.editTextDocumento);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        editTextFechaNacimiento = findViewById(R.id.editTextDate);
        editTextPeliculaFavorita = findViewById(R.id.editTextText3);
        editTextColorFavorito = findViewById(R.id.editTextText4);
        editTextComidaFavorita = findViewById(R.id.editTextText5);
        editTextLibroFavorito = findViewById(R.id.editTextText6);
        editTextCancionFavorita = findViewById(R.id.editTextText7);
        editTextDescripcionPersonal = findViewById(R.id.editTextTextMultiLine);

        checkBoxComida = findViewById(R.id.checkBox);
        checkBoxMusica = findViewById(R.id.checkBox1);
        checkBoxDeporte = findViewById(R.id.checkBox2);
        checkBoxCine = findViewById(R.id.checkBox3);
        checkBoxVideojuegos = findViewById(R.id.checkBox4);
        checkBoxViajes = findViewById(R.id.checkBox5);
        checkBoxLibros = findViewById(R.id.checkBox6);

        radioButtonMasculino = findViewById(R.id.radioButton);
        radioButtonFemenino = findViewById(R.id.radioButton2);
        radioButtonCasado = findViewById(R.id.radioButton3);
        radioButtonSoltero = findViewById(R.id.radioButton4);

        spinnerTipoTelefono = findViewById(R.id.spinner);
        spinnerTipoCorreo = findViewById(R.id.spinner2);
        spinnerVideojuegoFavorito = findViewById(R.id.spinner3);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{
                "Casa", "Personal", "Trabajo", "Emergencia"
        });
        spinnerTipoTelefono.setAdapter(adaptador);
        spinnerTipoCorreo.setAdapter(adaptador);

        ArrayAdapter<String> adaptadorVideojuegos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{
                "Sonic", "Megaman", "Castlevania", "GTA", "Skyrim", "Hollow Knight", "Mario", "Mortal Kombat", "League of Legends"
        });
        spinnerVideojuegoFavorito.setAdapter(adaptadorVideojuegos);
    }

    public void enviarDatos(View view) {
        String aficiones = "";
        if (checkBoxComida.isChecked()) aficiones += "Comida";
        if (checkBoxMusica.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Música";
        if (checkBoxDeporte.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Deporte";
        if (checkBoxCine.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Cine";
        if (checkBoxVideojuegos.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Videojuegos";
        if (checkBoxViajes.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Viajes";
        if (checkBoxLibros.isChecked()) aficiones += (aficiones.isEmpty() ? "" : ", ") + "Libros";

        String sexo = radioButtonMasculino.isChecked() ? "Masculino" : "Femenino";
        String estadoCivil = radioButtonCasado.isChecked() ? "Casado" : "Soltero";

        String nombre = editTextNombre.getText().toString();
        String apellidos = editTextApellidos.getText().toString();
        String documento = editTextDocumento.getText().toString();
        int edad = Integer.parseInt(editTextEdad.getText().toString());
        String email = editTextEmail.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String tipoTelefono = spinnerTipoTelefono.getSelectedItem().toString();
        String tipoCorreo = spinnerTipoCorreo.getSelectedItem().toString();
        String direccion = editTextDireccion.getText().toString();
        String fechaNacimiento = editTextFechaNacimiento.getText().toString();
        String videojuegoFavorito = spinnerVideojuegoFavorito.getSelectedItem().toString();
        String peliculaFavorita = editTextPeliculaFavorita.getText().toString();
        String colorFavorito = editTextColorFavorito.getText().toString();
        String comidaFavorita = editTextComidaFavorita.getText().toString();
        String libroFavorito = editTextLibroFavorito.getText().toString();
        String cancionFavorita = editTextCancionFavorita.getText().toString();
        String descripcionPersonal = editTextDescripcionPersonal.getText().toString();

        UserModel userModel = new UserModel(
                nombre, apellidos, documento, edad, email, telefono, tipoCorreo, tipoTelefono, direccion,
                fechaNacimiento, estadoCivil, sexo, videojuegoFavorito, peliculaFavorita, colorFavorito,
                comidaFavorita, libroFavorito, cancionFavorita, aficiones, descripcionPersonal
        );

        UserManager.getInstance(this).addUser(userModel);

        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        intent.putExtra("userModel", userModel);
        startActivity(intent);
    }

    public void verUsuarios(View view) {
        Intent intent = new Intent(MainActivity.this, UsuariosActivity.class);
        startActivity(intent);
    }

    public void abrirBuscar(View view) {
        Intent intent = new Intent(MainActivity.this, ConsultarPorID.class);
        startActivity(intent);
    }

    public void abrirEditar(View view) {
        Intent intent = new Intent(MainActivity.this, Editar.class);
        startActivity(intent);
    }

    public void abrirCalculadora(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityCalculadora.class);
        startActivity(intent);
    }
}



