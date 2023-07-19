package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Crear_Cuenta extends AppCompatActivity {
    EditText Nombre, Apellido, Correo, Contraseña, ConfirmarContraseña;
    String Msj;
    Boolean validado;
    WebServiceInicioSesion obj = new WebServiceInicioSesion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        Objects.requireNonNull(getSupportActionBar()).hide();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
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
        if(Nombre.getText().toString().isEmpty()
                ||Apellido.getText().toString().isEmpty()
                ||Correo.getText().toString().isEmpty()
                ||Contraseña.getText().toString().isEmpty()||
                ConfirmarContraseña.getText().toString().isEmpty())
        {
            Nombre.setError("Ingrese su nombre!");
            Apellido.setError("Ingrese su apellido");
            Correo.setError("Ingrese su correo");
            Contraseña.setError("Ingrese una contraseña");
            Toast.makeText(this, "Alerta,Te faltan datos por llenar!",
                    Toast.LENGTH_SHORT).show();
        }

        else{
            String password = Contraseña.getText().toString();
            String confirmPassword = ConfirmarContraseña.getText().toString();
            if(!password.equals(confirmPassword)){

                Contraseña.setError("Las contraseñas no coinciden");
                ConfirmarContraseña.setError("Las contraseñas no coinciden");

            }else{
                ConfirmarContraseña.setError(null);
                Msj = obj.insertar(Nombre.getText().toString(),
                        Apellido.getText().toString(),
                        Correo.getText().toString(),
                        Contraseña.getText().toString());
                if (Msj.equals("500")){
                    Toast.makeText(this, "Esta cuenta ya existe", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(getApplicationContext(),IniciarSesion.class);
                    startActivity(i);
                }
            }




        }



    }









}

