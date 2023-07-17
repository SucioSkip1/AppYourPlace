
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

public class interfaz_ver_citas extends AppCompatActivity {
RecyclerView rv_ver_citas;
adapter_ver_citas adapter;
webservice_ver_citas obj = new webservice_ver_citas();
    private List<String> itemList = new ArrayList<>();
    private List<String> itemList2 = new ArrayList<>();
    private List<String> itemList3 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_ver_citas);
        rv_ver_citas = findViewById(R.id.rv_ver_citas);
        rv_ver_citas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter_ver_citas(itemList, itemList2, itemList3);
        rv_ver_citas.setAdapter(adapter);
        adapter.setOnItemClickListener(new adapter_ver_citas.OnItemClickListener()
    {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),"Hiciste clic en:" +position,Toast.LENGTH_LONG).show();
            }
        });
        new MiAsyncTask().execute();
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
                    itemList.add(json_data.getString("HORA"));
                    itemList2.add(json_data.getString("PAGO"));
                    itemList3.add(json_data.getString("NOTAS"));

                }

                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), progress[0], Toast.LENGTH_LONG).show();
            }
        }

    }



}