package com.example.yourplace;

import static com.example.yourplace.WebServiceInicioSesion.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class IniciarSesion extends AppCompatActivity {
    String Msj;
    WebServiceInicioSesion obj = new WebServiceInicioSesion();
    //Declaran variables
    EditText Nombre, Contraseña;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //Vincular vista con su instancia
        Nombre = findViewById(R.id.plain_txt_InCorreo);
        Contraseña = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_entrar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = Nombre.getText().toString().trim();
                String password = Contraseña.getText().toString().trim();
                login(usuario, password);
            }
        });
    }

    private void login(String usuario, String password) {
        if (usuario.isEmpty() || password.isEmpty()) {
            Toast.makeText(IniciarSesion.this, "Por favor, ingresa usuario y contraseña", Toast.LENGTH_SHORT).show();
        } else {
            new LoginTask().execute(usuario, password);
        }

    }
    public void irCrearCuenta(View view) {
        Intent i = new Intent(getApplicationContext(), Crear_Cuenta.class);
        startActivity(i);
    }

    public void llenarCampos(View view) {
        Nombre.setText("Eduardo");
        Contraseña.setText("123");}
    private class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String usuario = params[0];
            String password = params[1];
            return WebServiceInicioSesion.login(usuario, password);
        }

        @Override
        protected void onPostExecute(String response) {
            Log.d("LoginResponse", response); // Imprimir la respuesta en el Logcat
            // Aquí puedes procesar la respuesta del servidor
            if (response.equals("Inicio de sesión exitoso")) {
                Toast.makeText(IniciarSesion.this, response, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), seleccionaUsuario.class);
                startActivity(intent);
            } else if (response.equals("Usuario no registrado")) {
                Toast.makeText(IniciarSesion.this, response, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(IniciarSesion.this, "Error al iniciar sesión"+response, Toast.LENGTH_SHORT).show();
            }
        }
    }
}