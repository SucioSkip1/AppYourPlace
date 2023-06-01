package com.example.yourplace;


import android.app.ListActivity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ver_opiniones extends ListActivity{
    MatrixCursor datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String [] colDatos =new String []{"_id","image","nombre","opinion","calificacion","hora"};
        datos =new MatrixCursor(colDatos);

        datos.addRow(new Object[] {"0",R.drawable.ava,"Eduardo Marcial","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});
        datos.addRow(new Object[] {"1",R.drawable.dos,"Carlos Zavala","El corte estuvo bien, pero el local muy sucio","Puntuacion: ☆☆☆☆☆","Fecha:18/4/2023"});
        datos.addRow(new Object[] {"2", R.drawable.trres,"Jessica Meneses","No me gusto para nada el servicio.","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});
        datos.addRow(new Object[] {"3",R.drawable.cuatro,"Regina Moreno","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});
        datos.addRow(new Object[] {"4",R.drawable.cinco,"Pineda Aguillon","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});
        datos.addRow(new Object[] {"5",R.drawable.seis,"Edgar Candelario","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});
        datos.addRow(new Object[] {"6",R.drawable.siete,"Erick Clapton","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});
        datos.addRow(new Object[] {"7",R.drawable.ocho,"Anonimo","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});
        datos.addRow(new Object[] {"8",R.drawable.cero,"","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"});

        String [] Columnas = {"image","nombre","opinion","calificacion","hora"};
        int [] vistas = {R.id.img_cliente_ver_opiniones,
                R.id.txt_nombre_ver_opiniones,
                R.id.txt_opinion_ver_opiniones,
                R.id.txtcalificacion_ver_opiniones,
                R.id.txt_hora_ver_opiniones
        };
        SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, R.layout.activity_ver_opiniones,datos,Columnas,vistas,1);
        setListAdapter(adapter);
    }


}