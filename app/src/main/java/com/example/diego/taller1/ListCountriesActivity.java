package com.example.diego.taller1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ListCountriesActivity extends Activity {

    JSONObject countries_list;
    String[] country_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_countries);

        try {
            countries_list = new JSONObject(loadJSONFromAsset());
            JSONArray paisesArray = countries_list.getJSONArray("paises");

            country_name = new String[paisesArray.length()];

            for (int i=0; i < paisesArray.length(); i++){
                JSONObject jsonObject = paisesArray.getJSONObject(i);
                String pais = jsonObject.getString("nombre_pais");
                country_name[i] = pais;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> countries_adapter = new ArrayAdapter<String>(this,
                R.layout.row, country_name);

        ListView mylistview = (ListView) findViewById(R.id.countries_name);
        mylistview.setAdapter(countries_adapter);


    }

    public String loadJSONFromAsset(){
        String json = null;

        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return json;
    }


}
