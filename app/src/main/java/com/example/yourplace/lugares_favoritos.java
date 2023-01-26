package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ActionMode;
import android.view.View;
import android.widget.Toast;

public class lugares_favoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_favoritos);
    }

    public void irAgendarCita(View view){
        Intent intent = new Intent(getApplicationContext(),agendar_cita.class);
        startActivity(intent);
    }

    public void irVerPefil(View view){
        Intent intent = new Intent(getApplicationContext(),perfil_barberia.class);
        startActivity(intent);
    }
    public void llamarTelefono(View view) {
        // verificar si el permiso esta autorizado
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:5576166860"));
            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(lugares_favoritos.this,new String[] { Manifest.permission.CALL_PHONE},
                    2000);
            Toast.makeText(this, "Acceso otorgado", Toast.LENGTH_SHORT).show();
        }
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 2000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5576166860"));
                    startActivity(intent);

                }
                else {
                    ActivityCompat.requestPermissions(lugares_favoritos.this,new String[] { Manifest.permission.CALL_PHONE},
                            2000);
                    Toast.makeText(this, "Acceso otorgado", Toast.LENGTH_SHORT).show();

                }
                return;
        }


    }












    public void iraInterfazUsuario(View view){
        Intent i = new Intent(getApplicationContext(),interfazUsuario.class);
        startActivity(i);
    }
}