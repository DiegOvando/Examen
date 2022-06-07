package com.example.examenc1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLimpiar, btnSalir, btnSiguiente;
    private EditText txtNombre, txtBase, txtAltura;
    private Rectangulo rectangulo = new Rectangulo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtBase = (EditText) findViewById(R.id.txtBase);
        txtAltura = (EditText) findViewById(R.id.txtAltura);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtBase.setText("");
                txtAltura.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor ingresar su nombre",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtBase.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar la base",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtAltura.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar la altura",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    //Funciones
                    Intent intent = new Intent(MainActivity.this,rectan.class);
                    //intent.putExtra("usuario", txtUsuario.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("nombre", txtNombre.getText().toString());
                    bundle.putSerializable("base", txtBase.getText().toString());
                    bundle.putSerializable("altura", txtAltura.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar App?");
                confirmar.setMessage("Se descartara toda la informacion. ");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nada
                    }
                }); confirmar.show();
            }
        });
    }

}
