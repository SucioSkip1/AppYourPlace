package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class selPromocion extends AppCompatActivity {
    TextView nomPromocion,desPromocion,restante_promo,distanciaPromocion;
    ImageView imgDePromocion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel_promocion);
        nomPromocion = findViewById(R.id.txt_nombre_promocion);
        desPromocion = findViewById(R.id.txt_des_promocion);
        restante_promo = findViewById(R.id.txt_tiempo_promocion_sel_promoi);
        distanciaPromocion = findViewById(R.id.txt_distancia_promocion_sel_promo);
        imgDePromocion = findViewById(R.id.img_sel_promocion);
        Bundle recVer_promociones = this.getIntent().getExtras();
        int img_sel_promocion = Integer.parseInt(recVer_promociones.getString("imgDePromocion"));
        String nomSelPromocion = recVer_promociones.getString("nomPromo");
        String desSelPromocion = recVer_promociones.getString("desPromocion");
        String timeSelPromocion= recVer_promociones.getString("tiempo_res_promo");
        String dis_Sel_promocion = recVer_promociones.getString("distancia_promo");
        imgDePromocion.setImageResource(img_sel_promocion);
        nomPromocion.setText(nomSelPromocion);
        desPromocion.setText(desSelPromocion);
        restante_promo.setText(timeSelPromocion);
        distanciaPromocion.setText(dis_Sel_promocion);

    }
    public void trazarRura(View view){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6"));
            startActivity(intent);

    }
    public void verSimilares(View view)
    {
        Intent i = new Intent(getApplicationContext(),ver_promociones.class);
        startActivity(i);
    }
    public void verLocal(View view){
        Intent i = new Intent(getApplicationContext(), perfil_barberia.class);
        startActivity(i);
    }
}