package com.roberterrera.programmersbylocale.view;

import android.os.AsyncTask;
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

        String locality = getIntent().getStringExtra("locality");
        setTitle("Programmers in "+locality);

        LoadProgrammersTask loadProgrammersTask = new LoadProgrammersTask();
        loadProgrammersTask.execute();
    }

    public class LoadProgrammersTask extends AsyncTask<Void, Void, Void>{

        String jsonFile = "android_model_challenge.json";

        List<String> programmerNames = new ArrayList<>();
        List<String> platformList = new ArrayList<>();
        List<Programmer> programmerList = new ArrayList<>();

        PeopleViewAdapter adapter = new PeopleViewAdapter(programmerNames, platformList, programmerList, PeopleViewActivity.this);

        /* Get locality data passed from MainActivity */
        int localityPos = getIntent().getIntExtra("locality pos", 0);

        @Override
        protected Void doInBackground(Void... voids) {

            /* Load list of programmers based on location selected */
            try {
                loadProgrammers(programmerNames, platformList, programmerList, jsonFile, localityPos);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setUpPeopleRecyclerView(programmerNames, adapter);
        }
    }
}