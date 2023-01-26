package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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

public class interfazUsuario extends AppCompatActivity {
EditText Buscador;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_usuario);
        Buscador = findViewById(R.id.editText_Buscador);

    }
public void buscador(View view){
        if (Buscador.getText().toString().isEmpty()){
            Toast.makeText(this, "Las casillas estan vacias", Toast.LENGTH_SHORT).show();
    }else{

            Buscador.setText("");
            Toast.makeText(this, "No hay negocios disponibles", Toast.LENGTH_SHORT).show();
    }
}
    public void notificacion(View view){
        Toast.makeText(this, "No tienes ninguna notificacion", Toast.LENGTH_SHORT).show();
    }
      public void irLugaresFavoritos (View view){
        Intent i = new Intent(getApplicationContext(),lugares_favoritos.class);
        startActivity(i);
      }
    public void tomarFoto(View view){
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }else{
            ActivityCompat.requestPermissions(interfazUsuario.this,new String[] { Manifest.permission.CAMERA},
                    4000);

        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 4000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(interfazUsuario.this,new String[] { Manifest.permission.CAMERA},
                            4000);

                }
                return;
        }


    }




}