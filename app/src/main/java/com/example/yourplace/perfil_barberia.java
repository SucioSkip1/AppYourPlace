package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class perfil_barberia extends AppCompatActivity {
    RecyclerView Recyclerview;
    listaOpiniones adapter1;
    private List<String> nombreCliente = new ArrayList<>();
    private List<String> opinion = new ArrayList<>();
    private List<String> calificacion = new ArrayList<>();
    private List<Integer> listaImgClientes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_barberia);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Recyclerview = findViewById(R.id.rv_perfil_barberia);
        Recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter1 = new listaOpiniones(nombreCliente, opinion, calificacion, listaImgClientes);
        Recyclerview.setAdapter(adapter1);
        nombreCliente.add("Eduardo Marcial♫");
        nombreCliente.add("Edgar Salinas ☻");
        nombreCliente.add("Jessica Camargo◘");
        nombreCliente.add("Carlos Zavala♠");
        nombreCliente.add("Loredo Miguel•");
        nombreCliente.add("Joxan Garcia♣");
        nombreCliente.add("El amigo anonimo");
        nombreCliente.add("Anton Ego");
        nombreCliente.add("Enrique Gomez");
        nombreCliente.add("Regina Molina♥");
        //----------------------
        opinion.add("Muy buen servicio, 10 de 10.");
        opinion.add("Buen servicio, se puede mejorar mas...");
        opinion.add("No me gusto el corte, me dejo muy pelon :(");
        opinion.add("Que guapo el barbero");
        opinion.add("Esperaba mas del lugar, solo lo bueno que era barato...");
        opinion.add("kien atiende?, no me hatendieron vien");
        opinion.add("Excelente servicio!, el barbero muy educado!, mas gente asi");
        opinion.add("Estuve esperando media hora, no me dejaron pasar.");
        opinion.add("Me cobraron caro, espero no volver a ir");
        opinion.add("Ese local es muy bueno, pero el barbero muy lento");
        //----------------------
        calificacion.add("★★★★☆");
        calificacion.add("★★☆☆☆");
        calificacion.add("★★★★★");
        calificacion.add("★☆☆☆☆");
        calificacion.add("★★★★☆");
        calificacion.add("★★☆☆☆");
        calificacion.add("☆☆☆☆☆");
        calificacion.add("☆☆☆☆☆");
        calificacion.add("★★★☆☆");
        calificacion.add("☆☆☆☆☆");
        //----------------------
        listaImgClientes.add(R.drawable.ava);
        listaImgClientes.add(R.drawable.cinco);
        listaImgClientes.add(R.drawable.cuatro);
        listaImgClientes.add(R.drawable.dos);
        listaImgClientes.add(R.drawable.trres);
        listaImgClientes.add(R.drawable.cuatro);
        listaImgClientes.add(R.drawable.cinco);
        listaImgClientes.add(R.drawable.seis);
        listaImgClientes.add(R.drawable.siete);
        listaImgClientes.add(R.drawable.ocho);
        adapter1.notifyDataSetChanged();
        adapter1.setOnItemClickListener(new listaOpiniones.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
    }

    public void tomarFoto(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1); // Iniciar la actividad de la cámara y esperar el resultado
        } else {
            ActivityCompat.requestPermissions(perfil_barberia.this, new String[]{Manifest.permission.CAMERA}, 4000);
        }

    }

    public void irCatalogo(View view) {
        Intent i = new Intent(getApplicationContext(), catalogo.class);
        startActivity(i);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 4000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                } else {
                    ActivityCompat.requestPermissions(perfil_barberia.this, new String[]{Manifest.permission.CAMERA},
                            4000);

                }
                return;
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            // La foto se tomó exitosamente
            Intent i = new Intent(getApplicationContext(),contribuye_opinion.class);
            startActivity(i);
        }
    }
public void verPromociones(View view)
{
    Intent i = new Intent(getApplicationContext(), ver_promociones.class);
    startActivity(i);
}
}