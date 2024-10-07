package com.example.intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intent.Modelo.UserManager;
import com.example.intent.Modelo.UserModel;

public class Editar extends AppCompatActivity {

    private EditText buscarText, editTextNombre, editTextApellidos, editTextDocumento, editTextEdad, editTextEmail,
            editTextTelefono, editTextDireccion, editTextDate, editTextText3, editTextText4,
            editTextText5, editTextText2, editTextText8, editTextTextMultiLine2;

    private RadioButton rb1, rb2, rb3, rb4;

    private CheckBox checkBoxComida, checkBoxMusica, checkBoxDeporte, checkBoxCine, checkBoxVideojuegos, checkBoxViajes, checkBoxLibros;

    private Spinner spinnerTipoTelefono, spinnerTipoCorreo, spinnerVideojuegoFavorito;

    private Button buttonBuscar, buttonRegresar, buttonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        buscarText = findViewById(R.id.BuscarText);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextDocumento = findViewById(R.id.editTextDocumento);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        editTextDate = findViewById(R.id.editTextDate);
        editTextText3 = findViewById(R.id.editTextText3);
        editTextText4 = findViewById(R.id.editTextText4);
        editTextText5 = findViewById(R.id.editTextText5);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText8 = findViewById(R.id.editTextText8);
        editTextTextMultiLine2 = findViewById(R.id.editTextTextMultiLine2);
        rb1 = findViewById(R.id.radioButton3);
        rb2 = findViewById(R.id.radioButton4);
        rb3 = findViewById(R.id.radioButton);
        rb4 = findViewById(R.id.radioButton2);

        checkBoxComida = findViewById(R.id.checkBox);
        checkBoxMusica = findViewById(R.id.checkBox1);
        checkBoxDeporte = findViewById(R.id.checkBox2);
        checkBoxCine = findViewById(R.id.checkBox3);
        checkBoxVideojuegos = findViewById(R.id.checkBox4);
        checkBoxViajes = findViewById(R.id.checkBox5);
        checkBoxLibros = findViewById(R.id.checkBox6);

        spinnerTipoTelefono = findViewById(R.id.spinner);
        spinnerTipoCorreo = findViewById(R.id.spinner2);
        spinnerVideojuegoFavorito = findViewById(R.id.spinner3);

        buttonBuscar = findViewById(R.id.buttonBuscar);
        buttonRegresar = findViewById(R.id.button4);
        buttonGuardar = findViewById(R.id.button3);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{
                "", "Casa", "Personal", "Trabajo", "Emergencia"
        });
        spinnerTipoTelefono.setAdapter(adaptador);
        spinnerTipoCorreo.setAdapter(adaptador);

        ArrayAdapter<String> adaptadorVideojuegos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{
                "", "Sonic", "Megaman", "Castlevania", "GTA", "Skyrim", "Hollow Knight", "Mario", "Mortal Kombat", "League of Legends"
        });
        spinnerVideojuegoFavorito.setAdapter(adaptadorVideojuegos);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarID();
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });
    }

    private void buscarID() {
        String idText = buscarText.getText().toString();

        if (idText.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un ID válido.", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idText);
        UserModel user = UserManager.getInstance(this).getUserById(id);

        if (user != null) {
            editTextNombre.setText(user.getNombre());
            editTextApellidos.setText(user.getApellidos());
            editTextDocumento.setText(user.getDocumento());
            editTextEdad.setText(String.valueOf(user.getEdad()));
            editTextEmail.setText(user.getEmail());
            editTextTelefono.setText(user.getTelefono());
            editTextDireccion.setText(user.getDireccion());
            editTextDate.setText(user.getFechaNacimiento());
            editTextText3.setText(user.getPeliculaFavorita());
            editTextText4.setText(user.getColorFavorito());
            editTextText5.setText(user.getComidaFavorita());
            editTextText2.setText(user.getLibroFavorito());
            editTextText8.setText(user.getCancionFavorita());
            editTextTextMultiLine2.setText(user.getDescripcionPersonal());

            if(user.getEstadoCivil().equals("Casado")){
                rb1.setChecked(true);
            }else{
                rb2.setChecked(true);
            }

            if(user.getSexo().equals("Masculino")){
                rb3.setChecked(true);
            }else{
                rb4.setChecked(true);
            }

            String aficiones = user.getAficiones();
            String[] aficionesArray = aficiones.split(",");

            checkBoxComida.setChecked(false);
            checkBoxMusica.setChecked(false);
            checkBoxDeporte.setChecked(false);
            checkBoxCine.setChecked(false);
            checkBoxVideojuegos.setChecked(false);
            checkBoxViajes.setChecked(false);
            checkBoxLibros.setChecked(false);

            for (String aficion : aficionesArray) {
                switch (aficion.trim()) {
                    case "Comida":
                        checkBoxComida.setChecked(true);
                        break;
                    case "Musica":
                        checkBoxMusica.setChecked(true);
                        break;
                    case "Deporte":
                        checkBoxDeporte.setChecked(true);
                        break;
                    case "Cine":
                        checkBoxCine.setChecked(true);
                        break;
                    case "Videojuegos":
                        checkBoxVideojuegos.setChecked(true);
                        break;
                    case "Viajes":
                        checkBoxViajes.setChecked(true);
                        break;
                    case "Libros":
                        checkBoxLibros.setChecked(true);
                        break;
                }
            }

            ArrayAdapter<String> adaptadorTelefono = (ArrayAdapter<String>) spinnerTipoTelefono.getAdapter();
            ArrayAdapter<String> adaptadorCorreo = (ArrayAdapter<String>) spinnerTipoCorreo.getAdapter();
            ArrayAdapter<String> adaptadorVideojuegos = (ArrayAdapter<String>) spinnerVideojuegoFavorito.getAdapter();

            int telefonoPosition = adaptadorTelefono.getPosition(user.getTipoTelefono());
            spinnerTipoTelefono.setSelection(telefonoPosition != -1 ? telefonoPosition : 0);

            int correoPosition = adaptadorCorreo.getPosition(user.getTipoCorreo());
            spinnerTipoCorreo.setSelection(correoPosition != -1 ? correoPosition : 0);

            int videojuegoPosition = adaptadorVideojuegos.getPosition(user.getVideojuegoFavorito());
            spinnerVideojuegoFavorito.setSelection(videojuegoPosition != -1 ? videojuegoPosition : 0);

            Toast.makeText(this, "Usuario encontrado: " + user.getNombre(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    private void regresar() {
        Toast.makeText(this, "Regresando", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void guardar() {
        String idText = buscarText.getText().toString();
        if (idText.isEmpty()) {
            Toast.makeText(this, "No se puede guardar sin un ID.", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idText);
        UserModel user = UserManager.getInstance(this).getUserById(id);

        if (user != null) {
            user.setNombre(editTextNombre.getText().toString());
            user.setApellidos(editTextApellidos.getText().toString());
            user.setDocumento(editTextDocumento.getText().toString());
            user.setEdad(Integer.parseInt(editTextEdad.getText().toString()));
            user.setEmail(editTextEmail.getText().toString());
            user.setTelefono(editTextTelefono.getText().toString());
            user.setDireccion(editTextDireccion.getText().toString());
            user.setFechaNacimiento(editTextDate.getText().toString());
            user.setPeliculaFavorita(editTextText3.getText().toString());
            user.setColorFavorito(editTextText4.getText().toString());
            user.setComidaFavorita(editTextText5.getText().toString());
            user.setLibroFavorito(editTextText2.getText().toString());
            user.setCancionFavorita(editTextText8.getText().toString());
            user.setDescripcionPersonal(editTextTextMultiLine2.getText().toString());

            String estadoCivil = rb1.isChecked() ? "Casado" : "Soltero";
            user.setEstadoCivil(estadoCivil);

            String sexo = rb3.isChecked() ? "Masculino" : "Femenino";
            user.setSexo(sexo);

            StringBuilder aficionesBuilder = new StringBuilder();
            if (checkBoxComida.isChecked()) aficionesBuilder.append("Comida,");
            if (checkBoxMusica.isChecked()) aficionesBuilder.append("Musica,");
            if (checkBoxDeporte.isChecked()) aficionesBuilder.append("Deporte,");
            if (checkBoxCine.isChecked()) aficionesBuilder.append("Cine,");
            if (checkBoxVideojuegos.isChecked()) aficionesBuilder.append("Videojuegos,");
            if (checkBoxViajes.isChecked()) aficionesBuilder.append("Viajes,");
            if (checkBoxLibros.isChecked()) aficionesBuilder.append("Libros,");

            String aficiones = aficionesBuilder.length() > 0 ? aficionesBuilder.substring(0, aficionesBuilder.length() - 1) : "";
            user.setAficiones(aficiones);

            user.setTipoTelefono(spinnerTipoTelefono.getSelectedItem().toString());
            user.setTipoCorreo(spinnerTipoCorreo.getSelectedItem().toString());
            user.setVideojuegoFavorito(spinnerVideojuegoFavorito.getSelectedItem().toString());

            UserManager.getInstance(this).updateUser(user);

            Toast.makeText(this, "Información guardada exitosamente.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se puede guardar, usuario no encontrado.", Toast.LENGTH_SHORT).show();
        }
    }
}
