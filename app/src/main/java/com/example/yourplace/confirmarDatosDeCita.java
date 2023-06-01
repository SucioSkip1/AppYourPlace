package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class confirmarDatosDeCita extends AppCompatActivity {
        TextView txtnombreCorte,txtPrecioCorte,txtHora,txtPago,txtNotas;
        ImageView cover;
    String nombreCorte,Hora,Pago,precioCorte,Nota;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos_de_cita);
        txtPrecioCorte= findViewById(R.id.PrecioCorte);
        txtnombreCorte = findViewById(R.id.nombreCorte);
        txtHora = findViewById(R.id.Hora);
        txtPago= findViewById(R.id.Pago);
        txtNotas = findViewById(R.id.Notas);
            cover = findViewById(R.id.imgCorte);





         Bundle rec= this.getIntent().getExtras();
          nombreCorte= rec.getString("nombreCorte1");
            txtnombreCorte.setText(nombreCorte);
             Hora = rec.getString("Time");
            txtHora.setText(Hora);
            Pago = rec.getString("pago");
            txtPago.setText(Pago);
             Nota = rec.getString("Notas");
            txtNotas.setText(Nota);
             precioCorte = rec.getString("precioCorte1");
            txtPrecioCorte.setText(precioCorte);
        img  = Integer.parseInt(rec.getString("img2"));
cover.setImageResource(img);

    }

    public void confirmarDatos(View view){
        Intent i = new Intent(getApplicationContext(),perfil_barberia.class);
        startActivity(i);
        Toast.makeText(this, "Se ha agregado tu cita con exito!", Toast.LENGTH_SHORT).show();
    }

    public void editarDatos(View view){
        Intent i = new Intent(getApplicationContext(),catalogo.class);
        startActivity(i);
        Toast.makeText(this, "Cambia tus datos!", Toast.LENGTH_SHORT).show();
    }
}