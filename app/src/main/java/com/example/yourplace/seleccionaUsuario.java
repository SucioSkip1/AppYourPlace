package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class seleccionaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_usuario);







    }







    public void interfazUsuario(View view){
        Intent i = new Intent(getApplicationContext(),interfazUsuario.class);
        startActivity(i);
    }
    public void interfazNegocio(View view){
        Intent i = new Intent(getApplicationContext(),interfazNegocio.class);
        startActivity(i);
    }

}