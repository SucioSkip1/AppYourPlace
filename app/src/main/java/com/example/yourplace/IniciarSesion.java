package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {

    //Declaran variables
    EditText Correo ,Contraseña;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
      //Vincular vista con su instancia
     Correo =findViewById(R.id.plain_txt_InCorreo);
     Contraseña = findViewById(R.id.txt_password);




    }
    public void irCrearCuenta(View view){
        Intent i = new Intent(getApplicationContext(),Crear_Cuenta.class);
        startActivity(i);
    }
    public void llenarCampos(View view){
        Correo.setText("Edu");
        Contraseña.setText("123");
    }
    public void metodoLog(View view){
        // Acciones
        String usr = Correo.getText().toString();
        String nom = "Edu";
        String pass = "123";


        if (Correo.getText().toString().isEmpty() && Contraseña.getText().toString().isEmpty())

        {
            Toast.makeText(this, "Las casillas estan vacias", Toast.LENGTH_SHORT).show();

        }else {
            if (Correo.getText().toString().equals(nom) && Contraseña.getText().toString().equals(pass)) {

                Toast.makeText(this, "Verificando datos", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),seleccionaUsuario.class);
                startActivity(i);
            } else {
                Correo.setText("");
                Contraseña.setText("");
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        }


}
    }