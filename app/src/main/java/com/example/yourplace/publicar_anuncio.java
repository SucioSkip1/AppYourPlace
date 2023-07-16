package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class publicar_anuncio extends AppCompatActivity {
EditText nombreAnuncio, desAnuncio,txt_id_anuncio;
Spinner spDistancia, spFormaPago;
WS_PublicarAnuncio obj = new WS_PublicarAnuncio();
    String Msj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_anuncio);
        Objects.requireNonNull(getSupportActionBar()).hide();
        txt_id_anuncio=findViewById(R.id.txt_id_anuncio_publicar_anuncio);
        nombreAnuncio = findViewById(R.id.txt_nombre_publicar_anuncio);
        spDistancia = findViewById(R.id.sp_distancia_anuncio_publicar_anuncio);
        spFormaPago = findViewById(R.id.sp_metodo_pago_publicar_anuncio);
        desAnuncio = findViewById(R.id.txt_des_publicar_anuncio);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }



    public void publicarAnuncio(View view){
        if (      txt_id_anuncio.getText().toString().isEmpty()||
                nombreAnuncio.getText().toString().isEmpty()
                ||spDistancia.getSelectedItem().equals("Elija una opcion")||
                spFormaPago.getSelectedItem().equals("Elija una opcion")||
                desAnuncio.getText().toString().isEmpty()){
            nombreAnuncio.setError("Coloque el nombre del anuncio");
            desAnuncio.setError("Escriba la descripcion del anuncio");
            Toast.makeText(this, "Faltan datos por llenar!", Toast.LENGTH_SHORT).show();
        }else{
        Msj = obj.insertar(txt_id_anuncio.getText().toString(),nombreAnuncio.getText().toString(),
                spDistancia.getSelectedItem().toString(),
                spFormaPago.getSelectedItem().toString(),
                desAnuncio.getText().toString());
            Toast.makeText(this, Msj, Toast.LENGTH_SHORT).show();
        }


    }

    public void buscarAnuncio(View view){
        if (txt_id_anuncio.getText().toString().isEmpty()){
            txt_id_anuncio.setError("Ingrese el nombre a buscar");
            Toast.makeText(this, "Faltan datos por llenar!", Toast.LENGTH_SHORT).show();
        }
        else{
            Msj = obj.buscar(txt_id_anuncio.getText().toString());
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
                txt_id_anuncio.setText(json_data.getString("ID_ANUNCIO") );
                nombreAnuncio.setText(json_data.getString("NOMBRE"));
                String dis = json_data.getString("DIST");
                int index = obtenerIndiceDis(dis);
                spDistancia.setSelection(index);




                String p = json_data.getString("PAGO");
                int i = obtenerIndicePago(p);
                spFormaPago.setSelection(i);


                desAnuncio.setText(json_data.getString("DE"));

            }//Si hay un problema on el JSON parser se captura e error
            catch (JSONException e) {   //Se asocia el error a la salida en pantalla
                Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_LONG).show();
            }
        }
    }
    public void actualizarAnuncio(View view){
        if (nombreAnuncio.getText().toString().isEmpty()
                ||spDistancia.getSelectedItem().equals("Elija una opcion")||
                spFormaPago.getSelectedItem().equals("Elija una opcion")||
                desAnuncio.getText().toString().isEmpty()){
            nombreAnuncio.setError("Coloque el nombre del anuncio");
            desAnuncio.setError("Escriba la descripcion del anuncio");
            Toast.makeText(this, "Faltan datos por llenar!", Toast.LENGTH_SHORT).show();
        }else{
            Msj = obj.actualizar(txt_id_anuncio.getText().toString(),
                    nombreAnuncio.getText().toString(),
                    spDistancia.getSelectedItem().toString(),
                    spFormaPago.getSelectedItem().toString(),
                    desAnuncio.getText().toString());
            Toast.makeText(this, Msj, Toast.LENGTH_SHORT).show();
        }


    }
    private int obtenerIndiceDis(String disa) {
        String[] dis = getResources().getStringArray(R.array.distanciaAnuncio);
        for (int i = 0; i <dis.length; i++) {
            if (dis[i].equals(disa)) {
                return i;
            }
        }
        return 0; // Si no se encuentra el país, se selecciona el primer ítem del Spinner
    }

    private int obtenerIndicePago(String pa) {
        String[] pago = getResources().getStringArray(R.array.formaPago);
        for (int i = 0; i < pago.length; i++) {
            if (pago[i].equals(pa)) {
                return i;
            }
        }
        return 0; // Si no se encuentra el país, se selecciona el primer ítem del Spinner
    }






}