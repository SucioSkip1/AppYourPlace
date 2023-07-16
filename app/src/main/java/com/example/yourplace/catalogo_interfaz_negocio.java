package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class catalogo_interfaz_negocio extends AppCompatActivity {

        EditText txt_id,txtnombre_corte,txtprecio,txt_descorte;
    String Msj;
    WebServiceCatalogoInterfazNegocio obj = new WebServiceCatalogoInterfazNegocio();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_catalogo_interfaz_negocio);
        txt_id = findViewById(R.id.id_corte_catalofo_interfazNegocio);
        txtnombre_corte = findViewById(R.id.nom_corte_interfaz_negocio);
        txtprecio = findViewById(R.id.precio_interfaz_negocio);
        txt_descorte = findViewById(R.id.descripcion_interfaz_negocio);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }
    public void Insertar(View view){
        if (txt_id.getText().toString().isEmpty()||
            txtnombre_corte.getText().toString().isEmpty()||
                txtprecio.getText().toString().isEmpty()||
                txt_descorte.getText().toString().isEmpty()
        )

        {

            Toast.makeText(this, "Alerta!,Datos faltanes", Toast.LENGTH_SHORT).show();
        }
        else{
            Msj = obj.insertar(
                    txt_id.getText().toString(),
                    txtnombre_corte.getText().toString(),
                    txtprecio.getText().toString(),
                    txt_descorte.getText().toString());
            Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_SHORT).show();
            txt_id.setText("");
            txtnombre_corte.setText("");
            txtprecio.setText("");
            txt_descorte.setText("");
        }
    }

    public void buscarCorte(View view){
            if (txt_id.getText().toString().isEmpty()){
                Toast.makeText(this, "Alerta!,Datos faltanes", Toast.LENGTH_SHORT).show();

            }
        else{
            Msj = obj.buscar(txt_id.getText().toString());
                try {
                    //Almacenar la respuesta JSON del servidor en un arreglo e tipo JSON
                    JSONArray jArray = new JSONArray(Msj);
                    //POr cada registro del arreglo JSON recuperado procesar...
                    JSONObject json_data = null;
                    for (int i = 0; i < jArray.length(); i++) {
                        //EL JSON parser crea un OBJETO JSON por cada registro del arreglo
                        json_data = jArray.getJSONObject(i);
                    }
                    txt_id.setText(json_data.getString("ID_CORTE"));
                    txtnombre_corte.setText(json_data.getString("NOMBRE_CORTE"));
                    txtprecio.setText(json_data.getString("PRECIO"));
                    txt_descorte.setText(json_data.getString("DES"));



                }//Si hay un problema on el JSON parser se captura e error
                catch (JSONException e) {   //Se asocia el error a la salida en pantalla
                    Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_LONG).show();
                }
            }
    }
    public void actualizar(View view){
        if (txt_id.getText().toString().isEmpty()||
                txtnombre_corte.getText().toString().isEmpty()||
                txtprecio.getText().toString().isEmpty()||
                txt_descorte.getText().toString().isEmpty()
        )

        {

            Toast.makeText(this, "Alerta!,Datos faltanes", Toast.LENGTH_SHORT).show();
        }
        else{
            Msj = obj.actualizar(
                    txt_id.getText().toString(),
                    txtnombre_corte.getText().toString(),
                    txtprecio.getText().toString(),
                    txt_descorte.getText().toString());
            Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_SHORT).show();
            txt_id.setText("");
            txtnombre_corte.setText("");
            txtprecio.setText("");
            txt_descorte.setText("");
        }

    }
    public void borrar(View view){
        if (txt_id.getText().toString().isEmpty()) {
            Toast.makeText(this, "Agrega el ID a borrar", Toast.LENGTH_SHORT).show();

        }

        else{
            Msj = obj.borrar(txt_id.getText().toString());
            //JSON PARSER -- Decodificar datos obtenidos del WEBSERVICE
            try {
                //Almacenar la respuesta JSON del servidor en un arreglo e tipo JSON
                JSONArray jArray = new JSONArray(Msj);
                //POr cada registro del arreglo JSON recuperado procesar...
                JSONObject json_data = null;
                for (int i = 0; i < jArray.length(); i++) {
                    //EL JSON parser crea un OBJETO JSON por cada registro del arreglo
                    json_data = jArray.getJSONObject(i);
                }
                txt_id.setText(json_data.getString("ID_CORTE"));



            }//Si hay un problema on el JSON parser se captura e error
            catch (JSONException e) {   //Se asocia el error a la salida en pantalla
                Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_LONG).show();
                txt_id.setText("");
                txtnombre_corte.setText("");
                txtprecio.setText("");
                txt_descorte.setText("");
            }
        }
    }
}