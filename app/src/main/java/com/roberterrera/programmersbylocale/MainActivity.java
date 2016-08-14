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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_list)
    RecyclerView mRecyclerView;

    private List<String> locales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("Select a locale");

        locales = new ArrayList<>();
        try {
            loadLocales(locales);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        parseJSON(loadJSONFromAsset());

        LocaleViewAdapter mAdapter = new LocaleViewAdapter(locales, MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        if (locales.size() > 0) {
            if (mRecyclerView != null) {

                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(mAdapter);

            } else Log.d("SetupRecyclerView", "RecyclerView or adapter are null.");
        } else Log.d("LOCALES.SIZE", "List size is 0.");
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
