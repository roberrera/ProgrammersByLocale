package com.roberterrera.programmersbylocale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.roberterrera.programmersbylocale.model.JSONResponse;
import com.roberterrera.programmersbylocale.model.ProgrammerLocation;
import com.roberterrera.programmersbylocale.model.adapters.LocaleViewAdapter;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> localesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Select a locale");

        /* Load list of localities from JSON data */
        localesList = new ArrayList<>();
        try {
            loadLocales(localesList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setUpRecyclerView();
    }

    public void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_list);

        LocaleViewAdapter mAdapter = new LocaleViewAdapter(localesList, MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        if (localesList.size() > 0) {
            if (recyclerView != null) {

                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(mAdapter);

            }
        }
    }

    public void loadLocales(List<String> locales) throws JSONException {
        Gson gson = new Gson();
        String jsonFile = loadJSONFromAsset();

        try {
            JSONResponse response = gson.fromJson(jsonFile,
                    JSONResponse.class);
            List<ProgrammerLocation> result = response.getResponse().getLocations();

        for (int i = 0; i < result.size(); i++){
            String locale = response.getResponse().getLocations().get(i).getLocality();
                locales.add(locale);
                Log.d("Locale: ", String.valueOf(locale));
            }
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
        Log.d("Locales: ", String.valueOf(locales));
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("android_model_challenge.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        System.out.println(json);
        return json;
    }
}
