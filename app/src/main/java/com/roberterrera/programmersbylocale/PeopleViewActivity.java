package com.roberterrera.programmersbylocale;

import android.os.Bundle;

import com.roberterrera.programmersbylocale.model.adapters.PeopleViewAdapter;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PeopleViewActivity extends ActivityMethods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        /* Get locality data passed from MainActivity */
        String locality = getIntent().getStringExtra("locality");
        int localityPos = getIntent().getIntExtra("locality pos", 0);

        setTitle("Programmers in "+locality);

        List<String> programmerNames = new ArrayList<>();
        PeopleViewAdapter adapter = new PeopleViewAdapter(programmerNames, this);
        String jsonFile = "android_model_challenge.json";

        /* Load list of localities from JSON data */
        try {
            loadProgrammers(programmerNames, jsonFile, localityPos);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setUpPeopleRecyclerView(programmerNames, adapter);
    }
}
