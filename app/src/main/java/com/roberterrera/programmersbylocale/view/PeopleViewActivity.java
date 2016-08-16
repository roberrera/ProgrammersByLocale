package com.roberterrera.programmersbylocale.view;

import android.os.Bundle;

import com.roberterrera.programmersbylocale.R;
import com.roberterrera.programmersbylocale.model.Programmer;
import com.roberterrera.programmersbylocale.model.adapters.PeopleViewAdapter;
import com.roberterrera.programmersbylocale.presenter.ActivityMethods;

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

        String jsonFile = "android_model_challenge.json";
        List<String> programmerNames = new ArrayList<>();
        List<String> platformList = new ArrayList<>();
        List<Programmer> programmerList = new ArrayList<>();

        PeopleViewAdapter adapter = new PeopleViewAdapter(programmerNames, platformList, programmerList, this);

        /* Load list of programmers based on location selected */
        try {
            loadProgrammers(programmerNames, platformList, programmerList, jsonFile, localityPos);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setUpPeopleRecyclerView(programmerNames, adapter);
    }
}