package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class IniciarSesion extends AppCompatActivity {
    String Msj;
    WebServiceInicioSesion obj = new WebServiceInicioSesion();
    //Declaran variables
    EditText Nombre ,Contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        Objects.requireNonNull(getSupportActionBar()).hide();
      //Vincular vista con su instancia
        Nombre =findViewById(R.id.plain_txt_InCorreo);
     Contraseña = findViewById(R.id.txt_password);




    }
    public void irCrearCuenta(View view){
        Intent i = new Intent(getApplicationContext(),Crear_Cuenta.class);
        startActivity(i);
    }
    public void llenarCampos(View view){
        Nombre.setText("Edu");
        Contraseña.setText("123");
    }
    public void metodoLog(View view){
        // Acciones
        if (Nombre.getText().toString().isEmpty() || Contraseña.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Las casillas estan vacias", Toast.LENGTH_SHORT).show();

        }else {
            Intent i = new Intent(getApplicationContext(),seleccionaUsuario.class);
            startActivity(i);
        }
}
    }