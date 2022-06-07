package com.example.examenc1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class rectan extends AppCompatActivity {

    private TextView lblUsuario, lblBase, lblAltura, lblArea, lblPerimetro;
    private Button btnRegresar, btnCalcular;
    private RadioButton rdArea, rdPerimetro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectan);

        Bundle datos = getIntent().getExtras();
        final Rectangulo rectangulo = (Rectangulo) datos.getSerializable("Rectangulo");

        rdArea = (RadioButton) findViewById(R.id.rdArea);
        rdPerimetro = (RadioButton) findViewById(R.id.rdPerimetro);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        lblBase = (TextView) findViewById(R.id.lblBase);
        lblAltura = (TextView) findViewById(R.id.lblAltura);
        lblArea = (TextView) findViewById(R.id.lblArea);
        lblPerimetro = (TextView) findViewById(R.id.lblPerimetro);

        lblUsuario.setText(datos.getString("nombre"));
        lblBase.setText(datos.getString("base"));
        lblAltura.setText(datos.getString("altura"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float altura = Integer.parseInt(lblAltura.getText().toString());
                final float base = Integer.parseInt(lblBase.getText().toString());
                final Rectangulo rectangulo = new Rectangulo(base, altura);
                if(rdArea.isChecked() == false && rdPerimetro.isChecked() == false){
                    lblArea.setText("Debe marcar una opcion");
                }
                if(rdArea.isChecked() == true){
                    lblArea.setText("El area es: " +rectangulo.calcularArea());
                }else if(rdPerimetro.isChecked() == true){
                    lblPerimetro.setText("El perimetro es: " +rectangulo.calcularPerimetro());
                }
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(rectan.this);
                confirmar.setTitle("¿Regresar?");
                confirmar.setMessage("Se descartará toda la información ingresada");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nada
                    }
                });
                confirmar.show();
            }
        });
    }
}
