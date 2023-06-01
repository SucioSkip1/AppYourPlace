package com.example.yourplace;




import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ActionMode;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class lugares_favoritos extends ListActivity {
MatrixCursor datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String [] colDatos =new String []{"_id","img","nombreLocal","Direccion","gps","web","correo","tel"};
        datos =new MatrixCursor(colDatos);
        datos.addRow(new Object[]{
                "0",
                R.drawable.img_chaveta,
                "Refacciones automotrices LA CHAVETA",
                "Av. P. del Sur 350, Morelos 3ra Secc, 54935 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "www.google.com",
                "chaveta@hotmal.com",
                    "55761668660"});
        datos.addRow(new Object[]{
                "1",
                R.drawable.img_tortilleria,
                "TORTILLERIA \"Gerardo\"",
                "Av. P. del Sur 350, Morelos 3ra Secc, 54930 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "www.google.com",
                "chaveta@hotmal.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "2",
                R.drawable.img_tortilleria,
                "Panaderia \"Pan delicioso\"",
                "Av. P. del Sur 350, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "www.google.com",
                "correo@hotmal.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "3",
                R.drawable.img_tortilleria,
                "Barberia \"Los amigos\"",
                "Av. Carlos del canal 351, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "www.google.com",
                "correo@hotmal.com",
                "5576166860"});


        String [] Columnas = {"img","nombreLocal","Direccion","gps","web","correo"};
        int [] vistas = {R.id.imgLocal,R.id.nombreLocal,R.id.txtDireccion};
        SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, R.layout.activity_lugares_favoritos,datos,Columnas,vistas,1);
        setListAdapter(adapter);

    }

    public void onListItemClick(ListView parent, View view, int pos , long id){
        Bundle envioDatoslugaresFav = new Bundle();
        envioDatoslugaresFav.putString("imgLugaresFav", String.valueOf(datos.getInt(1)));
        envioDatoslugaresFav.putString("nombreLocalLugaresFav",datos.getString(2));
        envioDatoslugaresFav.putString("dir_lugaresFav", datos.getString(3));
        Intent i = new Intent(getApplicationContext(), perfilLocales.class);
        i.putExtras(envioDatoslugaresFav);
        startActivity(i);
    }


















}