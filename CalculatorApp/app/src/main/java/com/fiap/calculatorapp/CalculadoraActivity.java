package com.fiap.calculatorapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText edtNumero1, edtNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
    }

    public void calcular(View v) {

        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);

        double numero1 = Double.parseDouble(edtNumero1.getText().toString());
        double numero2 = Double.parseDouble(edtNumero2.getText().toString());

        double resultado = numero1 + numero2;

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Resultado");
        msg.setMessage(String.valueOf(resultado));
        msg.setNeutralButton("OK", null);
        msg.show();

    }





}
