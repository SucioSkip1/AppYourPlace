package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class catalogo extends ListActivity {
    MatrixCursor datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_catalogo);

        String [] colDatos =new String []{"_id","img","nombreCorte","precio"};
        datos =new MatrixCursor(colDatos);
        datos.addRow(new Object[]{"0",R.drawable.cero,"Tapefade","$120"});
        String [] Columnas = {"img","nombreCorte","precio"};
        int [] vistas = {R.id.logoBanda,R.id.txtTitulo,R.id.txtDes};
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