package com.roberterrera.programmersbylocale.presenter;

/**
 * Created by Rob on 8/13/16.
 */
public interface Presenter<V> {

    void attachView(V view);
    void detatchView();
}
