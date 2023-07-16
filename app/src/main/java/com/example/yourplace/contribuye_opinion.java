package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class contribuye_opinion extends AppCompatActivity {
        EditText nombre;
        Spinner sp1, sp2,sp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribuye_opinion);
        nombre = findViewById(R.id.txtNombreContribuye);
        sp1 = findViewById(R.id.spinner);
        sp3 = findViewById(R.id.spinner1);
        sp2 = findViewById(R.id.spinner2);
    }

    public void botonEnviar(View view){
        if (nombre.getText().toString().isEmpty()||
                sp1.getSelectedItem().equals("Elije una opcion")
        ||sp3.getSelectedItem().equals("Elije una opcion")
        ||sp2.getSelectedItem().equals("Elije una opcion"))
        {
            Toast.makeText(this, "Faltan datos por llenar!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(getApplicationContext(), perfil_barberia.class);
            startActivity(i);
        }
    }
    public void llenarDatos(View view){
        nombre.setText("Eduardo Marcial");
        sp1.setSelection(2);
        sp2.setSelection(4);
        sp3.setSelection(4);
    }
}