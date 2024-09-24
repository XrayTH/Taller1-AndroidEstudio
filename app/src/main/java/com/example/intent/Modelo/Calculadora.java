package com.example.intent.Modelo;

public class Calculadora {
    private StringBuilder entradaActual;
    private double primerOperando;
    private double segundoOperando;
    private String operador;
    private boolean operadorEstablecido;
    private boolean decimalUsado;

    public Calculadora() {
        entradaActual = new StringBuilder();
        operadorEstablecido = false;
        decimalUsado = false;
        limpiar();
    }

    public void agregarDigito(String digito) {
        entradaActual.append(digito);
    }

    public void agregarDecimal() {
        if (!decimalUsado) {
            if (entradaActual.length() == 0) {
                entradaActual.append("0");
            }
            entradaActual.append(".");
            decimalUsado = true;
        }
    }

    public void establecerOperador(String operador) {
        if (!operadorEstablecido) {
            primerOperando = Double.parseDouble(entradaActual.toString());
            this.operador = operador;
            entradaActual.setLength(0);
            decimalUsado = false;
            operadorEstablecido = true;
        }
    }

    public void calcular() {
        if (operadorEstablecido) {
            segundoOperando = Double.parseDouble(entradaActual.toString());
            switch (operador) {
                case "+":
                    primerOperando += segundoOperando;
                    break;
                case "-":
                    primerOperando -= segundoOperando;
                    break;
                case "×":
                    primerOperando *= segundoOperando;
                    break;
                case "÷":
                    if (segundoOperando != 0) {
                        primerOperando /= segundoOperando;
                    } else {
                        entradaActual.setLength(0);
                        entradaActual.append("Error");
                        return;
                    }
                    break;
            }
            entradaActual.setLength(0);
            entradaActual.append(primerOperando);
            operadorEstablecido = false;
            decimalUsado = false;
        }
    }

    public void limpiar() {
        entradaActual.setLength(0);
        primerOperando = 0;
        segundoOperando = 0;
        operadorEstablecido = false;
        decimalUsado = false;
    }

    public String obtenerTextoPantalla() {
        if (entradaActual.length() == 0) {
            return "0";
        }
        return entradaActual.toString();
    }

    public void eliminarUltimoDigito() {
        if (entradaActual.length() > 0) {
            entradaActual.deleteCharAt(entradaActual.length() - 1);
        }
    }

}


