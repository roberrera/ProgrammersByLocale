package com.roberterrera.programmersbylocale;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.roberterrera.programmersbylocale.model.JSONResponse;
import com.roberterrera.programmersbylocale.model.Programmer;
import com.roberterrera.programmersbylocale.model.ProgrammerLocation;
import com.roberterrera.programmersbylocale.model.Service;
import com.roberterrera.programmersbylocale.model.adapters.LocaleViewAdapter;
import com.roberterrera.programmersbylocale.model.adapters.PeopleViewAdapter;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Rob on 8/14/16.
 */
public class ActivityMethods extends AppCompatActivity implements ActivityInterface {

    @Override
    public void setUpLocaleRecyclerView(List<String> list, LocaleViewAdapter adapter) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_locale_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        if (list.size() > 0) {
            if (recyclerView != null) {
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    @Override
    public void setUpPeopleRecyclerView(List<String> list, PeopleViewAdapter adapter) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_people_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        if (list.size() > 0) {
            if (recyclerView != null) {
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    public String loadJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void loadLocales(List<String> locales, String fileName) throws JSONException {
        Gson gson = new Gson();
        String jsonFile = loadJSONFromAsset(fileName);

        try {
            JSONResponse response = gson.fromJson(jsonFile,
                    JSONResponse.class);
            List<ProgrammerLocation> result = response.getResponse().getLocations();

            for (int i = 0; i < result.size(); i++){
                String locale = response.getResponse().getLocations().get(i).getLocality();
                locales.add(locale);
            }
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadProgrammers(List<String> programmers, String fileName) throws JSONException {
        Gson gson = new Gson();
        String jsonFile = loadJSONFromAsset(fileName);

        try {
            Service response = gson.fromJson(jsonFile,
                    Service.class);
            List<Programmer> result = response.getProgrammers();

            for (int i = 0; i < result.size(); i++){
                String name = result.get(i).getName();
                programmers.add(name);
            }
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadDetails(Programmer programmer, String fileName) throws JSONException {
        //TODO: Add JSON call
    }
}
