package com.roberterrera.programmersbylocale.view;

import android.os.Bundle;

import com.roberterrera.programmersbylocale.R;
import com.roberterrera.programmersbylocale.model.adapters.LocaleViewAdapter;
import com.roberterrera.programmersbylocale.presenter.ActivityMethods;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActivityMethods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Select a locale");

        List<String> localesList = new ArrayList<>();
        LocaleViewAdapter adapter = new LocaleViewAdapter(localesList, this);
        String jsonFile = "android_model_challenge.json";

        /* Load list of localities from JSON data */
        try {
            loadLocales(localesList, jsonFile);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setUpLocaleRecyclerView(localesList, adapter);
    }
}
