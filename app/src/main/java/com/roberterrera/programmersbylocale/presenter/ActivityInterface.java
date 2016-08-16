package com.roberterrera.programmersbylocale.presenter;

import com.roberterrera.programmersbylocale.model.Programmer;
import com.roberterrera.programmersbylocale.model.adapters.LocaleViewAdapter;
import com.roberterrera.programmersbylocale.model.adapters.PeopleViewAdapter;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Rob on 8/14/16.
 */
public interface ActivityInterface {

    void setUpLocaleRecyclerView(List<String> list, LocaleViewAdapter adapter);
    void setUpPeopleRecyclerView(List<String> list, PeopleViewAdapter adapter);
    String loadJSONFromAsset(String fileName);
    void loadLocales(List<String> locales, String fileName) throws JSONException;
    void loadProgrammers (List<String> programmers, List<String> platformList,
                          List<Programmer> programmerList, String fileName,
                          int localityPosition) throws JSONException;
    String formatPhoneNumber (String phoneNumber);
}
