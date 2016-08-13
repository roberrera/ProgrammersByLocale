package com.roberterrera.programmersbylocale.presenter;

import com.roberterrera.programmersbylocale.model.ProgrammerLocation;

import java.util.List;

/**
 * Created by Rob on 8/13/16.
 */
public interface Presenter<V> {

    void attachView(V view);
    void detatchView();
    void loadLocales(List<ProgrammerLocation> locales);
}
