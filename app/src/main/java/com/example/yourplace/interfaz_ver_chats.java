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

public class interfaz_ver_chats extends AppCompatActivity {
RecyclerView rv_ver_chats;
adapter_ver_chats adapter;
web_ver_chats obj = new web_ver_chats();
    private List<String> itemList = new ArrayList<>();
    private List<String> itemList2 = new ArrayList<>();
    private List<String> itemList3 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_interfaz_ver_chats);
    rv_ver_chats =findViewById(R.id.rv_chats_entrantes);
    rv_ver_chats.setLayoutManager(new LinearLayoutManager(this));
    adapter = new adapter_ver_chats(itemList, itemList2, itemList3);
    rv_ver_chats.setAdapter(adapter);
        adapter.setOnItemClickListener(new adapter_ver_chats.OnItemClickListener() {
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
                    itemList.add(json_data.getString("NOMBRE"));
                    itemList2.add(json_data.getString("HORA"));
                    itemList3.add(json_data.getString("MENSAJE"));
                }

                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), progress[0], Toast.LENGTH_LONG).show();
            }
        }

    }
}