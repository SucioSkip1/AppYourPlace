package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class agendar_cita extends AppCompatActivity {
            EditText Time, Pago, Notas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita);
        Time = findViewById(R.id.text_time_hora_cita);
        Pago = findViewById(R.id.edit_txt_metodo_pago);
        Notas = findViewById(R.id.txt_observaciones);
    }



    public void btnAgendar(View view){
        if (Time.getText().toString().isEmpty()&&Pago.getText().toString().isEmpty()&&
        Notas.getText().toString().isEmpty()){
            Toast.makeText(this, "No has llenado los datos", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(getApplicationContext(),lugares_favoritos.class);
            startActivity(i);
            Toast.makeText(this, "Cita agregada con exito", Toast.LENGTH_SHORT).show();
        }
    }
}