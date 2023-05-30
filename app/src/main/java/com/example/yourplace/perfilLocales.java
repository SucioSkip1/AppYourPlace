package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class perfilLocales extends AppCompatActivity {
        TextView txtLocal, txtDir;
        ImageView imgLocal_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_locales);
        txtLocal = findViewById(R.id.txt_nombre_local_perfil_locales);
        txtDir = findViewById(R.id.txt_dir_perfil_locales);
        imgLocal_perfil = findViewById(R.id.img_Local_Perfil_Locales);
        Bundle recLugaresFav= this.getIntent().getExtras();
        int imgLocal = Integer.parseInt(recLugaresFav.getString("imgLugaresFav"));
        String nomLocal1 = recLugaresFav.getString("nombreLocalLugaresFav");
        String dir = recLugaresFav.getString("dir_luagresFav");

        txtLocal.setText(nomLocal1);
        imgLocal_perfil.setImageResource(imgLocal);
        txtDir.setText(dir);

    }
}