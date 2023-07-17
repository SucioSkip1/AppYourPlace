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
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class interfazUsuario extends AppCompatActivity {
EditText Buscador;
RecyclerView listaLugaresTop;
private List <String> nombreLocal = new ArrayList<>();
    private List <String> desLocal = new ArrayList<>();
    private List <Integer> imgLocal = new ArrayList<>();
    listaLugaresTop adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_usuario);
        Buscador = findViewById(R.id.editText_Buscador);
        Objects.requireNonNull(getSupportActionBar()).hide();
        listaLugaresTop=findViewById(R.id.rv_lista_lugares_top);
        listaLugaresTop.setLayoutManager(new LinearLayoutManager(this));
    //Creacionb instancia
        adaptador = new listaLugaresTop(nombreLocal, desLocal, imgLocal);
        listaLugaresTop.setAdapter(adaptador);
        nombreLocal.add("Barberia");
        nombreLocal.add("Refaccionaria");
        nombreLocal.add("Vulcanizadora");
        nombreLocal.add("Papeleria");

        desLocal.add("Obtuvo 5 estrellas!");
        desLocal.add("Alcanzo el nivel 5!");
        desLocal.add("Compartio una foto");
        desLocal.add("Se volvio canon!");

        imgLocal.add(R.drawable.barbe);
        imgLocal.add(R.drawable.img_chaveta);
        imgLocal.add(R.drawable.barbe);
        imgLocal.add(R.drawable.img_chaveta);
        adaptador.notifyDataSetChanged();
    }
public void buscador(View view){
        if (Buscador.getText().toString().isEmpty()){
            Toast.makeText(this, "Las casillas estan vacias", Toast.LENGTH_SHORT).show();
    }else{

            Intent i = new Intent(getApplicationContext(),lugares_favoritos.class);
            startActivity(i);
    }
}
    public void notificacion(View view){
        Toast.makeText(this, "No tienes ninguna notificacion", Toast.LENGTH_SHORT).show();
    }
      public void irLugaresFavoritos (View view){
        Intent i = new Intent(getApplicationContext(),lugares_favoritos.class);
        startActivity(i);
      }
    public void tomarFoto(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1); // Iniciar la actividad de la cámara y esperar el resultado
        } else {
            ActivityCompat.requestPermissions(interfazUsuario.this, new String[]{Manifest.permission.CAMERA}, 4000);
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            // La foto se tomó exitosamente
            Intent i = new Intent(getApplicationContext(),perfil_barberia.class);
            startActivity(i);
        }
    }
    public void irPromociones (View view){
        Intent i = new Intent(getApplicationContext(), ver_promociones.class);
        startActivity(i);
    }

}