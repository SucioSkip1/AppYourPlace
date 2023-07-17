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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class perfilLocales extends AppCompatActivity {
        TextView txtLocal, txtDir;
        ImageView imgLocal_perfil;
    private static final int RQ1 = 1;
    String gps,tel,web,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_locales);
        Objects.requireNonNull(getSupportActionBar()).hide();
        txtLocal = findViewById(R.id.txt_nombre_local_perfil_locales);
        txtDir = findViewById(R.id.txt_dir_perfil_locales);
        imgLocal_perfil = findViewById(R.id.img_Local_Perfil_Locales);

        Bundle recLugaresFav= this.getIntent().getExtras();
        int imgLocal = Integer.parseInt(recLugaresFav.getString("imgLugaresFav"));
        String nomLocal1 = recLugaresFav.getString("nombreLocalLugaresFav");
        String dir = recLugaresFav.getString("dir_lugaresFav");
        txtLocal.setText(nomLocal1);
        imgLocal_perfil.setImageResource(imgLocal);
        txtDir.setText(dir);
         gps = recLugaresFav.getString("gps_lugares_fav");
         web = recLugaresFav.getString("redes_lugares_fav");
         correo = recLugaresFav.getString("email_lugares_fav");


    }
    public void verOpiniones(View view)
    {
        Intent i = new Intent(getApplicationContext(),ver_opiniones.class);
        startActivity(i);
    }
    public void verFotos(View view){
        Bundle envioVerFotosInterfaz = new Bundle();
        envioVerFotosInterfaz.putString("img_perfil_locales", String.valueOf(imgLocal_perfil));
        Intent i = new Intent(getApplicationContext(), ver_fotos_interfaz.class);
        i.putExtras(envioVerFotosInterfaz);
                startActivity(i);
    }
    public void streetview(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(gps));
        startActivity(intent);
    }
    public void llamarTelefono(View view){


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.
                CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.
                    CALL_PHONE}, RQ1);
        }
        else{
// Si ya se tienen permisos, continuar con la lógica de la aplicación
            // ...play
            Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+tel));
            startActivity(intent);

        }


    }
    public void mandarCorreo(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Cita, personal");
        intent.putExtra(Intent.EXTRA_TEXT, "Hola!, Me gustaria saber mas acerca de su negocio.");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {correo});
        startActivity(intent);
    }
    public void abrirPagina(View view) {

        Intent intentPA = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
        startActivity(intentPA);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Verificar si el requestCode es el mismo que se utilizó al solicitar permisos
        if (requestCode == RQ1) {
            // Verificar si el permiso fue concedido
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Si se concedió el permiso, continuar con la lógica de la aplicación
                // ...

                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+tel));
                startActivity(intent);
                Toast.makeText(this, "Se ha concedido el permiso", Toast.LENGTH_SHORT).show();
            } else {
                // Si se negó el permiso, mostrar un mensaje al usuario o cerrar la aplicaciónes
                // ...
                Toast.makeText(this, "Se ha negado el permiso", Toast.LENGTH_SHORT).show();
            }
        }
    }
}