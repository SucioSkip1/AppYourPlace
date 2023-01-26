package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void irIniciarSesion(View view) {
        Intent i = new Intent(getApplicationContext(),IniciarSesion.class);
        startActivity(i);
    }
    public void ircCrearCuennta(View view) {
        Intent i = new Intent(getApplicationContext(),Crear_Cuenta.class);
        startActivity(i);
    }
    public void abrirFB(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com"));
        startActivity(intent);
    }
    public void abrirTW(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://twitter.com/?lang=es"));
        startActivity(intent);
    }
    public void abrirGo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://myaccount.google.com/?hl=es_419&utm_source=OGB&utm_medium=act&pli=1"));
        startActivity(intent);
    }

}