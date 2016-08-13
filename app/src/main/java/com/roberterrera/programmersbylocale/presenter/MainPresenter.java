package com.roberterrera.programmersbylocale.presenter;

import com.roberterrera.programmersbylocale.view.MainView;

/**
 * Created by Rob on 8/13/16.
 */
public class MainPresenter implements Presenter<MainView> {

    public static String TAG = "MainPresenter";

    private MainView mainView;

    @Override
    public void attachView(MainView view) {
        this.mainView = view;
    }

    @Override
    public void detatchView() {
        this.mainView = null;
    }
}
