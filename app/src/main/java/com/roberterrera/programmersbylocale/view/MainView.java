package com.roberterrera.programmersbylocale.view;

import com.roberterrera.programmersbylocale.model.ProgrammerLocation;

import java.util.List;

/**
 * Created by Rob on 8/13/16.
 */
public interface MainView extends AppView {
    void loadLocales(List<ProgrammerLocation> locales);
}
