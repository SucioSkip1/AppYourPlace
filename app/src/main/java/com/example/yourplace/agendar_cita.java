package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class agendar_cita extends AppCompatActivity {
            EditText Time,  Notas,Pago;

            String nombreCorte,precio;
            int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita);
        Time = findViewById(R.id.text_time_hora_cita);
        Notas = findViewById(R.id.txt_observaciones);
        Pago = findViewById(R.id.edit_txt_metodo_pago);

        Bundle rec = this.getIntent().getExtras();
         nombreCorte = rec.getString("nombreCorte");
         precio = rec.getString("precio");
            img = Integer.parseInt(rec.getString("img"));
    }



    public void btnAgendar(View view){
        if (Time.getText().toString().isEmpty()&&Pago.getText().toString().isEmpty()&&
        Notas.getText().toString().isEmpty()){
            Toast.makeText(this, "No has llenado los datos", Toast.LENGTH_SHORT).show();
        }
        else{
            Bundle dato = new Bundle();
            dato.putString("nombreCorte1",nombreCorte);
            dato.putString("precioCorte1",precio);
            dato.putString("img2", String.valueOf(img));
            dato.putString("Time", Time.getText().toString());
            dato.putString("pago", Pago.getText().toString());
            dato.putString("Notas",Notas.getText().toString());
            Intent i = new Intent(getApplicationContext(),confirmarDatosDeCita.class);
            i.putExtras(dato);
            startActivity(i);
        }
    }
}