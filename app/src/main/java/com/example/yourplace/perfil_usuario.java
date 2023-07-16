package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class perfil_usuario extends AppCompatActivity {
TextView txtNombre,txtBio,txtOpinion,txtPuntuacion;
ImageView img_usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        txtNombre = findViewById(R.id.txt_nombre_perfil_usuario);
        txtBio = findViewById(R.id.txtx_biografia_perfil_usuario);
        txtOpinion = findViewById(R.id.opinion_perfil_usuario);
        txtPuntuacion = findViewById(R.id.punt_perfil_usuario);
        img_usuario  = findViewById(R.id.img_perfil_usuario);
        Bundle recuperaVerOpiniones = this.getIntent().getExtras();
        int imgPerfilUsuario = Integer.parseInt(recuperaVerOpiniones.getString("imgVerOpiniones"));
        String nomUsuario = recuperaVerOpiniones.getString("nomPerfilUsuario");
        String bioUsuario = recuperaVerOpiniones.getString("bioPerfilUsuario");
        String opinionUsuario = recuperaVerOpiniones.getString("opPerfilUsuario");
        String puntUsuario = recuperaVerOpiniones.getString("puntPerfilUsuario");
        img_usuario.setImageResource(imgPerfilUsuario);
        txtNombre.setText(nomUsuario);
        txtBio.setText(bioUsuario);
        txtOpinion.setText(opinionUsuario);
        txtPuntuacion.setText(puntUsuario);

    }
}