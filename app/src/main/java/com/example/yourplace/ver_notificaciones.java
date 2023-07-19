package com.example.yourplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ver_notificaciones extends AppCompatActivity {
        RecyclerView rv_verNotificacion,rv_ver_anuncios;
        adapterVerNotificaciones adapter;
        adapter_ver_anuncios adapter2;
        WS_verNotificaciones obj = new WS_verNotificaciones();
        WS_VerAnuncios obj2 = new WS_VerAnuncios();
    private List<String> itemList = new ArrayList<>();
    private List<String> itemList2 = new ArrayList<>();
    private List<String> itemList3 = new ArrayList<>();
    //-----------------------------------------------------------------
    private List<String> itemList4 = new ArrayList<>();
    private List<String> itemList5 = new ArrayList<>();
    private List<String> itemList6 = new ArrayList<>();
    private List<String> itemList7 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notificaciones);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //-------------------------------------------------------------
        rv_verNotificacion = findViewById(R.id.rv_ver_notificacion);
        rv_verNotificacion.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapterVerNotificaciones(itemList, itemList2, itemList3);
        rv_verNotificacion.setAdapter(adapter);
        new MiAsyncTask().execute();
        //--------------------------------------------------------------------
        rv_ver_anuncios = findViewById(R.id.rv_ver_anuncios);
        rv_ver_anuncios.setLayoutManager(new LinearLayoutManager(this));
        adapter2 = new adapter_ver_anuncios(itemList4,itemList5,itemList6,itemList7);
        rv_ver_anuncios.setAdapter(adapter2);
        new MiAsyncTask2().execute();

    }
    class MiAsyncTask extends AsyncTask<String, String, Void> {
        @Override
        protected Void doInBackground(String... parameter) {
            String msj = obj.buscar();
            publishProgress(msj);
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
                    itemList.add(json_data.getString("NOMBRE_CORTE"));
                    itemList2.add(json_data.getString("PRECIO"));
                    itemList3.add(json_data.getString("DES"));

                }

                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), progress[0], Toast.LENGTH_LONG).show();
            }
        }

    }

    class MiAsyncTask2 extends AsyncTask<String, String, Void> {
        @Override
        protected Void doInBackground(String... parameter) {
            String msj1 = obj2.buscar();
            publishProgress(msj1);
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
                    itemList4.add(json_data.getString("NOMBRE"));
                    itemList5.add(json_data.getString("DIST"));
                    itemList6.add(json_data.getString("PAGO"));
                    itemList7.add(json_data.getString("DE"));
                }

                adapter2.notifyDataSetChanged();
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), progress[0], Toast.LENGTH_LONG).show();
            }
        }

    }











}