package com.example.examenc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class rectan extends AppCompatActivity {

    private TextView lblUsuario, lblBase, lblAltura, lblResultado;
    private Button btnRegresar, btnCalcular;
    private Rectangulo rectangulo = new Rectangulo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectan);

        lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        lblBase = (TextView) findViewById(R.id.lblBase);
        lblAltura = (TextView) findViewById(R.id.lblAltura);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        final float base = Float.parseFloat(lblBase.getText().toString());
        final float altura = Float.parseFloat(lblAltura.getText().toString());

        rectangulo.setBase(base);
        rectangulo.setBase(altura);

        Bundle datos = getIntent().getExtras();
        lblUsuario.setText(datos.getString("nombre"));
        lblBase.setText(datos.getString("base"));
        lblAltura.setText(datos.getString("altura"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lblResultado.setText("El resultado es: " + rectangulo.calcularArea());
                lblResultado.setText("El resultado es: " + rectangulo.calcularPerimetro());
            }
        });
    }
}
