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
        //setContentView(R.layout.activity_lugares_favoritos);
        String [] colDatos =new String []{"_id","img","nombreLocal","Direccion"};
        datos =new MatrixCursor(colDatos);
        datos.addRow(new Object[]{"0",R.drawable.cero,"Los amigos","16 de Septiembre , Avenida Juarez"});
        String [] Columnas = {"img","nombreLocal","Direccion"};
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