package com.example.intent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intent.Modelo.Calculadora;

public class ActivityCalculadora extends AppCompatActivity {

    private TextView pantalla;
    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        pantalla = findViewById(R.id.display);
        calculadora = new Calculadora();
    }

    public void onNumberClick(View view) {
        String numero = ((TextView) view).getText().toString();
        calculadora.agregarDigito(numero);
        pantalla.setText(calculadora.obtenerTextoPantalla());
    }

    public void onOperatorClick(View view) {
        String operador = ((TextView) view).getText().toString();
        calculadora.establecerOperador(operador);
        pantalla.setText(calculadora.obtenerTextoPantalla());
    }

    public void onDecimalClick(View view) {
        calculadora.agregarDecimal();
        pantalla.setText(calculadora.obtenerTextoPantalla());
    }

    public void onClearClick(View view) {
        calculadora.limpiar();
        pantalla.setText(calculadora.obtenerTextoPantalla());
    }

    public void onEqualsClick(View view) {
        calculadora.calcular();
        pantalla.setText(calculadora.obtenerTextoPantalla());
    }

    public void onBackspaceClick(View view) {
        calculadora.eliminarUltimoDigito();
        pantalla.setText(calculadora.obtenerTextoPantalla());
    }

    public void regresar(View view){
        finish();
    }
}