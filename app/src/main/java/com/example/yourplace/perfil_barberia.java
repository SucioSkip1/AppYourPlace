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
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class perfil_barberia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_barberia);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public void tomarFoto(View view){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }else{
            ActivityCompat.requestPermissions(perfil_barberia.this,new String[] { Manifest.permission.CAMERA},
                    4000);

        }
    }

    public void irCatalogo(View view){
        Intent i = new Intent(getApplicationContext(),catalogo.class);
        startActivity(i);
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
                    ActivityCompat.requestPermissions(perfil_barberia.this,new String[] { Manifest.permission.CAMERA},
                            4000);

                }
                return;
        }


    }
}