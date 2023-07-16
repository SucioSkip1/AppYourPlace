package com.example.yourplace;

import android.app.ListActivity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ver_promociones extends ListActivity {
    MatrixCursor datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String [] colDatos =new String []{"_id","image","nombre","opinion","calificacion","hora"};
        datos =new MatrixCursor(colDatos);
        datos.addRow(new Object[] {
                "0",
                R.drawable.dosporuno,
                "Corte 2x1",
                "Llevate un corte si traes a tu hermano",
                "Vence en 3 horas",
                "Distancia_ 1 Km aproximado"});
        datos.addRow(new Object[] {"1",R.drawable.tacograti,"Tacos gratis!!!","Llevate 5 tacos si vienes con tu bisabuela ","Vence en 5 dias","Distancia: 1 Km aproximado"});
        datos.addRow(new Object[] {"2", R.drawable.teeef,"Vendo television!","La compre pero no me gusto, llevatela!."," Vence en 5 horas","Distancia 2KM"});
        datos.addRow(new Object[] {"3", R.drawable.f1f1f1f1,"2 Tennis en la compra de un par!","Solo hoy!, compra dos pares y llevate uno de regalo","Vence en 1 hora:","Distancia: 2 km aproximado"});
        datos.addRow(new Object[] {"4",R.drawable.dda,"Servicio de mecanica!","Ofrezco servicio de afinacion!","Vence en 5 horas","Distancia : 3 Km aproximado"});
        String [] Columnas = {"image","nombre","opinion","calificacion","hora"};
        int [] vistas = {R.id.img_ver_promociones,
                R.id.txt_titulo_ver_promociones,
                R.id.txt_des_ver_promociones,
                R.id.txt_tiempo_promocion,
                R.id.txt_precio_ver_promociones
        };
        SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, R.layout.activity_ver_promociones,datos,Columnas,vistas,1);
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView parent, View view, int pos , long id){
        Bundle envioPromocionesSelPromo = new Bundle();
        envioPromocionesSelPromo.putString("imgDePromocion",datos.getString(1));
        envioPromocionesSelPromo.putString("nomPromo", datos.getString(2));
        envioPromocionesSelPromo.putString("desPromocion", datos.getString(3));
        envioPromocionesSelPromo.putString("tiempo_res_promo",datos.getString(4));
        envioPromocionesSelPromo.putString("distancia_promo",datos.getString(5));
        Intent i = new Intent(getApplicationContext(), selPromocion.class);
        i.putExtras(envioPromocionesSelPromo);
        startActivity(i);

    }

}