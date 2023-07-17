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
                R.drawable.refa,
                "Refaccionaria \"Chaveta\"",
                "Av. P. del Sur 350, Morelos 3ra Secc, 54935 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "chaveta@hotmal.com",
                    "55761668660"});
        datos.addRow(new Object[]{
                "1",
                R.drawable.img_tortilleria,
                "TORTILLERIA \"Gerardo\"",
                "Av. P. del Sur 350, Morelos 3ra Secc, 54930 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "chaveta@hotmal.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "2",
                R.drawable.pana,
                "Panaderia \"Pan delicioso\"",
                "Av. P. del Sur 350, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "panaderia@hotmal.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "3",
                R.drawable.barbe,
                "Barberia \"Los amigos\"",
                "Av. Carlos del canal 351, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "barberia@hotmail.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "4",
                R.drawable.vulca,
                "Vulcanizadora \"El pepe\"",
                "Av. Carlos del canal 376, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "barberia@hotmail.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "5",
                R.drawable.pape,
                "Papeleria \"La peke\"",
                "Av. Carlos del canal 678, Morelos 3ra Secc, 54933 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "barberia@hotmail.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "6",
                R.drawable.zapa,
                "Zapateria \"El zapato feliz\"",
                "Av. Carlos del canal 351, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "barberia@hotmail.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "7",
                R.drawable.caarni,
                "Carniceria \"Toro loco\"",
                "Av. Carlos del canal 351, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "barberia@hotmail.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "8",
                R.drawable.pape,
                "Papeleria\"El libro feliz\"",
                "Av. Carlos del canal 351, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "barberia@hotmail.com",
                "5576166860"});
        datos.addRow(new Object[]{
                "9",
                R.drawable.ciber,
                "Ciber cafe \"Marianas Web\"",
                "Av. Carlos del canal 351, Morelos 3ra Secc, 54936 San Pablo de las Salinas, Méx.",
                "google.streetview:cbll=19.680228,-99.083703=&cbp=3,75,158.8,77.6",
                "https://www.google.com/?&bih=970&biw=1879&client=opera-gx&hs=lAa&hl=es-419",
                "barberia@hotmail.com",
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
        envioDatoslugaresFav.putString("dir_lugaresFav",datos.getString(3));
        envioDatoslugaresFav.putString("gps_lugares_fav",datos.getString(4));
        envioDatoslugaresFav.putString("redes_lugares_fav",datos.getString(5));
        envioDatoslugaresFav.putString("email_lugares_fav",datos.getString(6));
        Intent i = new Intent(getApplicationContext(), perfilLocales.class);
        i.putExtras(envioDatoslugaresFav);
        startActivity(i);
    }


















}