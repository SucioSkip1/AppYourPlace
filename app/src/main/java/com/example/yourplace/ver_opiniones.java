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

        String [] colDatos =new String []{"_id","image","nombre","opinion","calificacion","hora","bio"};
        datos =new MatrixCursor(colDatos);

        datos.addRow(new Object[] {
          /*0*/      "0",
                R.drawable.ava,
                "Eduardo Marcial",
                "Me gusto el corte, el servicio perfecto, pero puede mejorar mas",
                "Puntuacion: ☆☆☆☆☆",
                "Fecha:17/05/2023",
               /*6*/ "Persona sencilla, por amor a los zapatos, disfruto de comer en lugares elegantes"});
        datos.addRow(new Object[] {"1",R.drawable.dos,"Carlos Zavala","El corte estuvo bien, pero el local muy sucio","Puntuacion: ☆☆☆☆☆","Fecha:18/4/2023"
        ,"Soy un poco timido, pero siempre estoy dispuesto a probar nuevas cosas, me gusta la comida en exceso"});
        datos.addRow(new Object[] {"2", R.drawable.trres,"Jessica Meneses","No me gusto para nada el servicio.","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"
                ,"Me gusta salir a conocer restaurantes caros, siempre prefiero comer en la calle, para probar comida rica o bacterias poderosas."});
        datos.addRow(new Object[] {"3",R.drawable.cuatro,"Regina Moreno","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"
                ,"Siempre prefiero comprar mi ropa en locales de ropa, pero esta vez prefiero comprar ropa de fuera."});
        datos.addRow(new Object[] {"4",R.drawable.cinco,"Pineda Aguillon","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"
                ,"Prefiero comprar mis cosas en el super, pero si encuentro oferta me lo llevo."});
        datos.addRow(new Object[] {"5",R.drawable.seis,"Edgar Candelario","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"
                ,"Soy un critico que le gusta dejar muerto a sus clientes, porfavor no seas egoista!."});
        datos.addRow(new Object[] {"6",R.drawable.siete,"Erick Clapton","Pesimo, no vuelvo a ir en mi vida ↓","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"
                ,"Soy un poco timido, pero siempre estoy dispuesto a probar nuevas cosas, me gusta la comida en exceso"});
        datos.addRow(new Object[] {"7",R.drawable.ocho,"Anonimo","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"
                ,"Soy un poco timido, pero siempre estoy dispuesto a probar nuevas cosas, me gusta la comida en exceso"});
        datos.addRow(new Object[] {"8",R.drawable.cero,"Juan Perez","Me gusto el corte, el servicio perfecto, pero puede mejorar mas","Puntuacion: ☆☆☆☆☆","Fecha:17/05/2023"
                ,"Soy un poco timido, pero siempre estoy dispuesto a probar nuevas cosas, me gusta la comida en exceso"});

        String [] Columnas = {"image","nombre","opinion","calificacion","hora"};
        int [] vistas = {R.id.img_ver_promociones,
                R.id.txt_titulo_ver_promociones,
                R.id.txt_des_ver_promociones,
                R.id.txt_tiempo_promocion,
                R.id.txt_precio_ver_promociones
        };
        SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, R.layout.activity_ver_opiniones,datos,Columnas,vistas,1);
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView parent, View view, int pos , long id){
        Toast.makeText(this, "Has seleccionado la posicion: "+pos, Toast.LENGTH_LONG).show();
        Bundle envioDatosPerfilUsuario = new Bundle();
        envioDatosPerfilUsuario.putString("imgVerOpiniones",String.valueOf(datos.getInt(1)));
        envioDatosPerfilUsuario.putString("nomPerfilUsuario", datos.getString(2));
        envioDatosPerfilUsuario.putString("bioPerfilUsuario",datos.getString(6));
        envioDatosPerfilUsuario.putString("opPerfilUsuario", datos.getString(3));
        envioDatosPerfilUsuario.putString("puntPerfilUsuario", datos.getString(4));
        Intent i = new Intent(getApplicationContext(),perfil_usuario.class);
        i.putExtras(envioDatosPerfilUsuario);
        startActivity(i);


    }
}