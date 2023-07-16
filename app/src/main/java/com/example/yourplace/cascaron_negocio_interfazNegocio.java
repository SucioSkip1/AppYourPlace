package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class cascaron_negocio_interfazNegocio extends AppCompatActivity {
                TextView nombreLocalCascaron,dirLocalCascaron;
                ImageView imgCascaronLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cascaron_negocio_interfaz_negocio);
                nombreLocalCascaron = findViewById(R.id.txt_nombre_local_perfil_locales);
                Bundle recInterfazNegocio = this.getIntent().getExtras();
                dirLocalCascaron = findViewById(R.id.txt_dir_perfil_locales);
                imgCascaronLocal = findViewById(R.id.img_Local_Perfil_Locales);
                String nombreLocal = recInterfazNegocio.getString("nomLocalInterfazNegocios");
                String desLocal = recInterfazNegocio.getString("desNegocioInterfazNegocio");
                int imgLocal = Integer.parseInt(recInterfazNegocio.getString("imgNegocioInterfazNegocio"));
                nombreLocalCascaron.setText(nombreLocal);
                dirLocalCascaron.setText(desLocal);
                imgCascaronLocal.setImageResource(imgLocal);
    }

}