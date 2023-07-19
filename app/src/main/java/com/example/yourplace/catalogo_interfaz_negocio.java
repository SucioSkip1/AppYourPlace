package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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
    String msj,crud;
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
    class MiAsyncTask extends AsyncTask<String, String, Void> {
        @Override
        protected Void doInBackground(String... parameter) {
             msj = null;
            switch (parameter[0]) {
                case "insertar":
                    msj = obj.insertar(parameter[1],parameter[2],parameter[3],parameter[4]);
                    publishProgress(msj);
                    break;
                case "borrar":
                    msj = obj.borrar(parameter[1]);
                    publishProgress(msj);
                    break;
                case "actualizar":
                    msj = obj.actualizar(parameter[1], parameter[2], parameter[3], parameter[4]);
                    publishProgress(msj);
                    break;
                case "buscar":
                    msj = obj.buscar(parameter[1]);
                    publishProgress(msj);
                    break;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... progress) {
            super.onProgressUpdate(progress);
            try {
                JSONArray jArray = new JSONArray(progress[0]);
                JSONObject json_data = null;
                for (int i = 0; i < jArray.length(); i++) {
                    json_data = jArray.getJSONObject(i);
                }
                txt_id.setText(json_data.getString("ID_CORTE"));
                txtnombre_corte.setText(json_data.getString("NOMBRE_CORTE"));
                txtprecio.setText("$"+json_data.getString("PRECIO"));
                txt_descorte.setText(json_data.getString("DES"));

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), progress[0], Toast.LENGTH_LONG).show();
                progress[0] = msj;
            }
        }
    }
    public void buscar(View view){
        if (txt_id.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese el ID a buscar.", Toast.LENGTH_SHORT).show();
        }else{
            crud = "buscar";
            new MiAsyncTask().execute(crud,txt_id.getText().toString());

        }
    }
    public void insertar(View view){
        if (txt_id.getText().toString().isEmpty()||txtnombre_corte.getText().toString().isEmpty()||
                txtprecio.getText().toString().isEmpty()||txt_descorte.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Datos vacios, le faltan datos por llenar!", Toast.LENGTH_SHORT).show();
        }
        else{
            crud = "insertar";
            new MiAsyncTask().execute(crud,
                    txt_id.getText().toString(),txtnombre_corte.getText().toString(),
                    txtprecio.getText().toString(),txt_descorte.getText().toString());
            txt_id.setText("");
            txtprecio.setText("");
            txtnombre_corte.setText("");
            txt_descorte.setText("");

        }
    }

    public void actualizar(View view){
        if (txt_id.getText().toString().isEmpty()||txtnombre_corte.getText().toString().isEmpty()||
                txtprecio.getText().toString().isEmpty()||txt_descorte.getText().toString().isEmpty()){
            Toast.makeText(this, "Datos vacios, le faltan datos por llenar!", Toast.LENGTH_SHORT).show();

        }else{
            crud = "actualizar";
            new MiAsyncTask().execute(crud,
                    txt_id.getText().toString(),txtnombre_corte.getText().toString(),
                    txtprecio.getText().toString(),txt_descorte.getText().toString());
            txt_id.setText("");
            txtprecio.setText("");
            txtnombre_corte.setText("");
            txt_descorte.setText("");
        }
    }
    public void borrar (View view){
        if (txt_id.getText().toString().isEmpty()){
            Toast.makeText(this, "Faltan datos, escriba el ID!", Toast.LENGTH_SHORT).show();
        }else{
            crud = "borrar";
            new MiAsyncTask().execute(crud,txt_id.getText().toString());




        }
    }

}