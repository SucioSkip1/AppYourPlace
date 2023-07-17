package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ver_fotos_interfaz extends AppCompatActivity {
    RecyclerView rv_verfotos,rv_verfotos2;


    private List  <Integer> imgLocal = new ArrayList<>();


    adaptador_ver_fotos_interfaz adapter,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_fotos_interfaz);
    rv_verfotos = findViewById(R.id.rv_ver_fotos_interfaz);
    rv_verfotos.setLayoutManager(new LinearLayoutManager(this));
    rv_verfotos2 = findViewById(R.id.rv_ver_fotos_2);
    rv_verfotos2.setLayoutManager(new LinearLayoutManager(this));
    adapter = new adaptador_ver_fotos_interfaz(imgLocal);
    adapter2= new adaptador_ver_fotos_interfaz(imgLocal);
    rv_verfotos.setAdapter(adapter);
    rv_verfotos2.setAdapter(adapter2);
    imgLocal.add(R.drawable.carne);
    imgLocal.add(R.drawable.barbe);
    imgLocal.add(R.drawable.ciber);
    imgLocal.add(R.drawable.zapa);
    imgLocal.add(R.drawable.vulca);
    imgLocal.add(R.drawable.vulca);
    imgLocal.add(R.drawable.barbe);
    imgLocal.add(R.drawable.vulca);
    imgLocal.add(R.drawable.dda);
    imgLocal.add(R.drawable.torti);
    }
public  void irAmenu(View view){
    Intent i = new Intent(getApplicationContext(), interfazUsuario.class);
    startActivity(i);
}
}