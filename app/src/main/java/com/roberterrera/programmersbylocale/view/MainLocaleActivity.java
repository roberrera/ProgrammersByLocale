package com.roberterrera.programmersbylocale.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.roberterrera.programmersbylocale.R;
import com.roberterrera.programmersbylocale.presenter.MainPresenter;

import butterknife.ButterKnife;

public class MainLocaleActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("Select a Locale");

        presenter = new MainPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detatchView();
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
