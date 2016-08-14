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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                String locale = result.get(i).getLocality();
                locales.add(locale);
            }
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadProgrammers(List<String> programmers, String fileName, int localityPosition) throws JSONException {
        Gson gson = new Gson();

        String jsonFile = loadJSONFromAsset(fileName);
        String platform = null;
        String name = null;

        List<Service> serviceList = new ArrayList<>();
        List<Programmer> programmerList = new ArrayList<>();
        Map<String, List<Programmer>> platformMap = new HashMap<>();

        try {
            // Get the JSON response
            JSONResponse response = gson.fromJson(jsonFile,
                    JSONResponse.class);
            // Get the list of locations from the response.
            List<ProgrammerLocation> locationList = response.getResponse().getLocations();
            serviceList = locationList.get(localityPosition).getServices();

            /* Map the programming platform to the list of programmers
            * and add the names from that map to a list.
            */
            for (int i = 0; i < serviceList.size(); i++) {
                //TODO: Refactor to be more efficient and be O(n)
                programmerList = serviceList.get(i).getProgrammers();
                platform = serviceList.get(i).getPlatform();

                platformMap.put(platform, programmerList);

                for (int k = 0; k < programmerList.size(); k++) {
                    name = programmerList.get(k).getName();
                    programmers.add(name);
                }
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
