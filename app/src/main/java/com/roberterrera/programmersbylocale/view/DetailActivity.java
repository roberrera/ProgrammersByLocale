package com.roberterrera.programmersbylocale.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.roberterrera.programmersbylocale.R;

public class DetailActivity extends AppCompatActivity {

    String name = getIntent().getStringExtra("name");
//    String faveColor = getIntent().getStringExtra("color");
//    String phoneNum = getIntent().getStringExtra("phone");
//    int age = getIntent().getIntExtra("age", -2);
//    int weight = getIntent().getIntExtra("weight", -1);
//    boolean isArtist = getIntent().getBooleanExtra("artist", false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        Log.d("DETAILACITIVITY", name+", "+age+", "+weight+", "+faveColor+", "+phoneNum+", Is artist: "+isArtist);
        Log.d("DETAILACITIVITY", "Name passed through intent! +"+name);

    }
}
