package com.roberterrera.programmersbylocale.presenter;

import com.roberterrera.programmersbylocale.view.PeopleView;

/**
 * Created by Rob on 8/13/16.
 */
public class PeoplePresenter implements Presenter<PeopleView> {

    PeopleView peopleView;

    @Override
    public void attachView(PeopleView view) {
        this.peopleView = view;
    }

    @Override
    public void detatchView() {
        this.peopleView = null;
    }
}
