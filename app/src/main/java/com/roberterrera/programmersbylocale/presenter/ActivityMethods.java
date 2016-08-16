package com.roberterrera.programmersbylocale.presenter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.roberterrera.programmersbylocale.R;
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
                String locale = result.get(i).getLocality();
                locales.add(locale);
            }
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadProgrammers(List<String> programmers, List<String> platformList, List<Programmer> programmerList,
                                String fileName, int localityPosition) throws JSONException {

        String jsonFile = loadJSONFromAsset(fileName);
        String platform;
        String name;
        List<Service> serviceList;

        Gson gson = new Gson();

        try {
            /* Get the JSON response */
            JSONResponse response = gson.fromJson(jsonFile,
                    JSONResponse.class);
            /* Get the locality the user selected */
            List<ProgrammerLocation> locationList = response.getResponse().getLocations();
            serviceList = locationList.get(localityPosition).getServices();

            //TODO: Refactor to be more efficient (currently O(n^2) )
            for (int i = 0; i < serviceList.size(); i++) {

                /* 1. Access each programmer from the list of programmers
                *  within the Service array for this location.
                *  2. Get the platform associated with a list of programmers. */
                List<Programmer> tempProgList = serviceList.get(i).getProgrammers();
                platform = serviceList.get(i).getPlatform();

                for (int k = 0; k < tempProgList.size(); k++) {
                    /* Another way to match platform to programmer
                     could be to create a list of arrays, or to look at map pairs */

                    Programmer programmerObj = tempProgList.get(k);
                    programmerList.add(programmerObj);

                    platformList.add(platform);

                    name = tempProgList.get(k).getName();
                    programmers.add(name);
                }
            }

        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    public String formatPhoneNumber (String phoneNumber) {

        return String.format("(%s) %s-%s",
                phoneNumber.substring(0, 3),
                phoneNumber.substring(3, 6),
                phoneNumber.substring(6, 10));
    }
}
