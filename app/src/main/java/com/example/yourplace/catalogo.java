package com.example.yourplace;

import android.app.ListActivity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class catalogo extends ListActivity {
    MatrixCursor datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_catalogo);

        String [] colDatos =new String []{"_id","img","nombreCorte","precio"};
        datos =new MatrixCursor(colDatos);
        datos.addRow(new Object[]{"0",R.drawable.corteuno,"Tapefade","$120"});
        datos.addRow(new Object[]{"1",R.drawable.cortedos,"Casquete craneo","$50"});
        datos.addRow(new Object[]{"2",R.drawable.cortetres,"Ultrafade","$60"});
        datos.addRow(new Object[]{"3",R.drawable.cortecuatro,"Tapefade","$70"});
        datos.addRow(new Object[]{"4",R.drawable.cortecinco,"Tapefade","$80"});
        datos.addRow(new Object[]{"5",R.drawable.corteseis,"Tapefade","$20"});
        datos.addRow(new Object[]{"6",R.drawable.cortesiete,"Tapefade","$90"});
        datos.addRow(new Object[]{"7",R.drawable.corteocho,"Tapefade","$150"});
        datos.addRow(new Object[]{"8",R.drawable.cortenueve,"Tapefade","$45"});
        datos.addRow(new Object[]{"9",R.drawable.cortedies,"Tapefade","$80"});
        datos.addRow(new Object[]{"10",R.drawable.corteonce,"Tapefade","$120"});
        datos.addRow(new Object[]{"11",R.drawable.corteuno,"Tapefade","$120"});
        datos.addRow(new Object[]{"12",R.drawable.cortedos,"Tapefade","$120"});
        datos.addRow(new Object[]{"13",R.drawable.cortetres,"Tapefade","$100"});
        datos.addRow(new Object[]{"14",R.drawable.cero,"Tapefade","$70"});
        String [] Columnas = {"img","nombreCorte","precio"};
        int [] vistas = {R.id.imgLocal,R.id.nombreLocal,R.id.txtDireccion};
        SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, R.layout.activity_catalogo,datos,Columnas,vistas,1);
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView parent, View view, int pos , long id){
        Bundle envioDato = new Bundle();
        envioDato.putString("img", String.valueOf(datos.getInt(1)));
        envioDato.putString("nombreCorte",datos.getString(2));
        envioDato.putString("precio",datos.getString(3));
       Intent i = new Intent(getApplicationContext(),agendar_cita.class);
        i.putExtras(envioDato);
        startActivity(i);
    }

}