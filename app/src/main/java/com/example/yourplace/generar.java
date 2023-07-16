package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class generar extends AppCompatActivity {
    WSGenerarQR obj = new WSGenerarQR();
    String Msj;
    EditText    txt_id_generar_QR,txt_nombre_generar_QR,notas_generar_QR;
    Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar);
        Objects.requireNonNull(getSupportActionBar()).hide();
        txt_id_generar_QR = findViewById(R.id.txt_ID_QR_generarqr);
        txt_nombre_generar_QR = findViewById(R.id.txt_nombre_generar_qr);
        notas_generar_QR = findViewById(R.id.txt_generar_qr_notas);
        sp1 = findViewById(R.id.seleccion_generar_qr);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }

    public void insertarQR(View view){
        if (txt_id_generar_QR.getText().toString().isEmpty()||
        txt_nombre_generar_QR.getText().toString().isEmpty()||
                notas_generar_QR.getText().toString().isEmpty()||
                sp1.getSelectedItem().equals("Elije una opcion")

        )
        {
            txt_nombre_generar_QR.setError("Escriba su nombre");
            txt_id_generar_QR.setError("Escriba el ID");
            notas_generar_QR.setError("Escriba la nota");
            Toast.makeText(this, "Complete los datos solicitados.", Toast.LENGTH_SHORT).show();
        }
        else{

            Msj = obj.insertar(
                    txt_id_generar_QR.getText().toString(),
                    txt_nombre_generar_QR.getText().toString(),
                    sp1.getSelectedItem().toString(),
                    notas_generar_QR.getText().toString());
            Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_SHORT).show();
            txt_id_generar_QR.setText("");
                    txt_nombre_generar_QR.setText("");
                    sp1.setSelection(0);
                    notas_generar_QR.setText("");
        }




    }
    public void buscarQR(View view){
                if(txt_id_generar_QR.getText().toString().isEmpty()){
                    txt_id_generar_QR.setError("Escriba el ID que quiera buscar");
                }
                else{
                    Msj = obj.buscar(txt_id_generar_QR.getText().toString());
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
                        txt_id_generar_QR.setText(json_data.getString("ID_QR"));
                        txt_nombre_generar_QR.setText(json_data.getString("NOMBRE_QR"));
                        String qr = json_data.getString("SEL");
                        int index = obtenerIndicePais(qr);
                        sp1.setSelection(index);
                        notas_generar_QR.setText(json_data.getString("NOTAS"));



                    }//Si hay un problema on el JSON parser se captura e error
                    catch (JSONException e) {   //Se asocia el error a la salida en pantalla
                        Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_LONG).show();
                    }
                }



    }
    public void actualizarQR(View view) {
        if (txt_id_generar_QR.getText().toString().isEmpty()||
                txt_nombre_generar_QR.getText().toString().isEmpty()||
                notas_generar_QR.getText().toString().isEmpty()||
                sp1.getSelectedItem().equals("Elije una opcion")

        )
        {
            txt_nombre_generar_QR.setError("Escriba su nombre");
            txt_id_generar_QR.setError("Escriba el ID");
            notas_generar_QR.setError("Escriba la nota");

        }
        else{

            Msj = obj.actualizar(
                    txt_id_generar_QR.getText().toString(),
                    txt_nombre_generar_QR.getText().toString(),
                    sp1.getSelectedItem().toString(),
                    notas_generar_QR.getText().toString());
            Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_SHORT).show();
            txt_id_generar_QR.setText("");
            txt_nombre_generar_QR.setText("");
            sp1.setSelection(0);
            notas_generar_QR.setText("");
        }
    }

    public void borrarQR(View view){
        if (txt_id_generar_QR.getText().toString().isEmpty()){


        }else{
            try {
                Msj = obj.borrar(txt_id_generar_QR.getText().toString());
                //Almacenar la respuesta JSON del servidor en un arreglo e tipo JSON
                JSONArray jArray = new JSONArray(Msj);
                //POr cada registro del arreglo JSON recuperado procesar...
                JSONObject json_data = null;
                for (int i = 0; i < jArray.length(); i++) {
                    //EL JSON parser crea un OBJETO JSON por cada registro del arreglo
                    json_data = jArray.getJSONObject(i);
                }
                txt_id_generar_QR.setText(json_data.getString("ID_QR"));

            }//Si hay un problema on el JSON parser se captura e error
            catch (JSONException e) {   //Se asocia el error a la salida en pantalla
                txt_id_generar_QR.setText("");
                txt_nombre_generar_QR.setText("");
                sp1.setSelection(0);
                notas_generar_QR.setText("");
                Toast.makeText(getApplicationContext(), Msj, Toast.LENGTH_LONG).show();

            }
        }
    }
    private int obtenerIndicePais(String qr) {
        String[] paises = getResources().getStringArray(R.array.generaQR);
        for (int i = 0; i < paises.length; i++) {
            if (paises[i].equals(qr)) {
                return i;
            }
        }
        return 0; // Si no se encuentra el país, se selecciona el primer ítem del Spinner
    }
}