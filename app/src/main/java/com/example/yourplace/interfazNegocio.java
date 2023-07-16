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
        nombreNegocio.add("Taller mecanico");
        nombreNegocio.add("Refaccioanria");
        nombreNegocio.add("Paleteria");
        nombreNegocio.add("Vulcanizadora");
        //--------------------------------
        desNegocio.add("Manzana 087, Casitas San Pablo, 54925 San Pablo de las Salinas, Méx.");
        desNegocio.add("Perla 550, Casitas San Pablo, 54939 San Pablo de las Salinas, Méx.");
        desNegocio.add("Flores Villa, Casitas San Pablo, 54975 San Pablo de las Salinas, Méx.");
        desNegocio.add("Pera 231, Casitas San Pablo, 54936 San Pablo de las Salinas, Méx.");
        //-------------------------------
        img_negocio.add(R.drawable.dda);
        img_negocio.add(R.drawable.refa);
        img_negocio.add(R.drawable.carne);
        img_negocio.add(R.drawable.vulca);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle envInterfazNegocio = new Bundle();
                Intent i = new Intent(getApplicationContext(),cascaron_negocio_interfazNegocio.class);
            envInterfazNegocio.putString("nomLocalInterfazNegocios", nombreNegocio.get(position));
            envInterfazNegocio.putString("desNegocioInterfazNegocio", desNegocio.get(position));
            envInterfazNegocio.putString("imgNegocioInterfazNegocio", String.valueOf(img_negocio.get(position)));
                i.putExtras(envInterfazNegocio);
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