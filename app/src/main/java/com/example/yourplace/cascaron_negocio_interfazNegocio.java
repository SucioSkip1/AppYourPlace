package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class cascaron_negocio_interfazNegocio extends AppCompatActivity {
                TextView nombreLocalCascaron,dirLocalCascaron;
                ImageView imgCascaronLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cascaron_negocio_interfaz_negocio);
                    Objects.requireNonNull(getSupportActionBar()).hide();
                nombreLocalCascaron = findViewById(R.id.txt_nombre_cascaron_negocio_interfaz);
                Bundle recInterfazNegocio = this.getIntent().getExtras();
                dirLocalCascaron = findViewById(R.id.txt_des_cascaron_negocio_interfaz);
                imgCascaronLocal = findViewById(R.id.img_cascaron_negocio);
                String nombreLocal = recInterfazNegocio.getString("nomLocalInterfazNegocios");
                String desLocal = recInterfazNegocio.getString("desNegocioInterfazNegocio");
                int imgLocal = Integer.parseInt(recInterfazNegocio.getString("imgNegocioInterfazNegocio"));
                nombreLocalCascaron.setText(nombreLocal);
                dirLocalCascaron.setText(desLocal);
                imgCascaronLocal.setImageResource(imgLocal);
    }




    public void irACatalogo(View view){
        Intent i = new Intent(getApplicationContext(), catalogo_interfaz_negocio.class);
        startActivity(i);
    }
    public void irPublicarAnuncio(View view){
        Intent i = new Intent(getApplicationContext(), publicar_anuncio.class);
        startActivity(i);
    }
    public void irVerOpiniones(View view){
        Intent i = new Intent(getApplicationContext(), ver_opiniones.class);
        startActivity(i);
    }
    public void irVerCitas(View view){
        Intent i = new Intent(getApplicationContext(), interfaz_ver_citas.class);
        startActivity(i);
    }
    public void irVerChats(View view){
        Intent i = new Intent(getApplicationContext(), interfaz_ver_chats.class);
        startActivity(i);
    }
}