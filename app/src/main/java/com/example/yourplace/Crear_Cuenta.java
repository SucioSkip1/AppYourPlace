package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Crear_Cuenta extends AppCompatActivity {
    EditText Nombre, Apellido, Correo, Contraseña, ConfirmarContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Nombre = findViewById(R.id.txt_Nombre);
        Apellido = findViewById(R.id.txt_apellido);
        Correo = findViewById(R.id.txt_correo);
        Contraseña = findViewById(R.id.editTextTextPassword);
        ConfirmarContraseña = findViewById(R.id.editTextTextConfirmarPass);
    }

public void llenarCampos(View view){
        Nombre.setText("Eduardo");
        Apellido.setText("Marcial");
        Correo.setText("Pepito@gmail.com");
        Contraseña.setText("Pepito123");
    ConfirmarContraseña.setText("Pepito123");
}

    public void irInicio(View view) {

        if (Nombre.length() == 0) {
            Toast.makeText(this, "Ingrese un nombre", Toast.LENGTH_SHORT).show();
        }
        if (Apellido.length() == 0) {
            Toast.makeText(this, "Ingrese un apellido", Toast.LENGTH_SHORT).show();
        }

        if (Correo.length() == 0) {
            Toast.makeText(this, "Ingrese un correo", Toast.LENGTH_SHORT).show();
        }
        if (Contraseña.length() == 0) {
            Toast.makeText(this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
        }
        if (ConfirmarContraseña.length() == 0) {
            Toast.makeText(this, "Confirme la contraseña", Toast.LENGTH_SHORT).show();
        }

        else {
        Intent i = new Intent(getApplicationContext(), IniciarSesion.class);
        startActivity(i);
        Toast.makeText(this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();
    }
    }








}

