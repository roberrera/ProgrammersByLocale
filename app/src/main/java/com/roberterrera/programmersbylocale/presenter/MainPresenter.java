package com.roberterrera.programmersbylocale.presenter;

import com.google.gson.Gson;
import com.roberterrera.programmersbylocale.model.ProgrammerLocation;
import com.roberterrera.programmersbylocale.view.MainView;

import java.util.List;

/**
 * Created by Rob on 8/13/16.
 */
public class MainPresenter implements Presenter<MainView> {

    public static String TAG = "MainPresenter";

    private MainView mainView;
    private List<ProgrammerLocation> locales;

    @Override
    public void attachView(MainView view) {
        this.mainView = view;
    }

    @Override
    public void detatchView() {
        this.mainView = null;
    }

    @Override
    public void loadLocales(List<ProgrammerLocation> locales) {
        Gson gson = new Gson();
        for (ProgrammerLocation locale : locales){
            locale = gson.fromJson("locality", ProgrammerLocation.class);
            locales.add(locale);
        }
    }
}
