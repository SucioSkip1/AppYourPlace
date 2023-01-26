package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class interfazNegocio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_negocio);
    }


    public void irCatalogo(View view){
        Intent i = new Intent(getApplicationContext(),catalogo.class);
        startActivity(i);
    }


    public void abrirLocal(View view){
        Toast.makeText(this, "Local abierto", Toast.LENGTH_SHORT).show();
    }

   public void irGenerarQR(View view){
       Intent i = new Intent(getApplicationContext(),generar.class);
       startActivity(i);


    }







}