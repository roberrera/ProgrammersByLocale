package com.roberterrera.programmersbylocale.presenter;

import com.roberterrera.programmersbylocale.view.DetailView;

/**
 * Created by Rob on 8/13/16.
 */
public class DetailPresenter implements Presenter<DetailView>{

    DetailView detailView;

    @Override
    public void attachView(DetailView view) {
        this.detailView = view;
    }

    @Override
    public void detatchView() {
        this.detailView = null;
    }
}
