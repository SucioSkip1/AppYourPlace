package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class interfazNegocio extends AppCompatActivity {
RecyclerView RV;
    private List<String> nombreNegocio = new ArrayList<>();
    private List <String> desNegocio = new ArrayList<>();
    private List<Integer> img_negocio = new ArrayList();
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_negocio);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //Vinculacion del recycler view
        RV = findViewById(R.id.listaNegocios);
        RV.setLayoutManager(new LinearLayoutManager(this));
        //Creacion de la instancia de la lista
        adapter = new MyAdapter(nombreNegocio,desNegocio,img_negocio);
        RV.setAdapter(adapter);
        nombreNegocio.add("Ferreteria");
        nombreNegocio.add("Barberia");
        nombreNegocio.add("Paleteria");
        nombreNegocio.add("Restaurante");
        //--------------------------------
        desNegocio.add("Tienda ");
        desNegocio.add("Tienda fisica");
        desNegocio.add("Tienda fisica");
        desNegocio.add("Tienda fisica");
        //-------------------------------
        img_negocio.add(R.drawable.carne);
        img_negocio.add(R.drawable.carne);
        img_negocio.add(R.drawable.carne);
        img_negocio.add(R.drawable.carne);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle envioDatos = new Bundle();
                Intent i = new Intent(getApplicationContext(),cascaron_negocio_interfazNegocio.class);
                i.putExtras(envioDatos);
                startActivity(i);
                //i.putExtra("titulo",dataList.get(position));
            }
        });
    }


    public void irCatalogo(View view){
        Intent i = new Intent(getApplicationContext(), catalogo.class);
        startActivity(i);

    }


    public void abrirLocal(View view){
        Toast.makeText(this, "Local abierto", Toast.LENGTH_SHORT).show();
    }

   public void irGenerarQR(View view){
       Intent i = new Intent(getApplicationContext(),generar.class);
       startActivity(i);


    }
    public void irPublicar(View view){
        Intent i = new Intent(getApplicationContext(), publicar_anuncio.class);
        startActivity(i);
    }







}