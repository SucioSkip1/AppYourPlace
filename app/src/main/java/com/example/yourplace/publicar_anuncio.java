package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class publicar_anuncio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_anuncio);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }



    public void irPublicarAnuncio(View view){
        Toast.makeText(this, "Anuncio publicado correctamente", Toast.LENGTH_SHORT).show();
         Intent i = new Intent(getApplicationContext(),interfazNegocio.class);
        startActivity(i);


    }
}