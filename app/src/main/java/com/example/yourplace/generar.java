package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class generar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar);
        Objects.requireNonNull(getSupportActionBar()).hide();


    }

    public void generarQR(View view){
        Toast.makeText(this, "Catalogo generado", Toast.LENGTH_SHORT).show();
    }
    public void generarQRNegocio(View view){
        Toast.makeText(this, "QR del negocio Generado", Toast.LENGTH_SHORT).show();
    }
}