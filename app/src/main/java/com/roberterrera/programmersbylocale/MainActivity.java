package com.roberterrera.programmersbylocale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.roberterrera.programmersbylocale.model.ProgrammerLocation;
import com.roberterrera.programmersbylocale.model.adapters.LocaleViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_list)
    RecyclerView mRecyclerView;

    private List<ProgrammerLocation> programmerLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("Select a locale");

        programmerLocations = new ArrayList<>();

        setupRecyclerView(mRecyclerView);
        loadLocales(programmerLocations);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);

            RecyclerView.Adapter adapter = new LocaleViewAdapter(programmerLocations, MainActivity.this);
            recyclerView.setAdapter(adapter);
        } else Log.d("SetupRecyclerView", "RecyclerView is null.");
    }

    public void loadLocales(List<ProgrammerLocation> locales) {
        Gson gson = new Gson();
        for (ProgrammerLocation locale : locales){
            locale = gson.fromJson("locality", ProgrammerLocation.class);
            locales.add(locale);
        }
    }
}
