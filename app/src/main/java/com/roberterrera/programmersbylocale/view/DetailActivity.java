package com.roberterrera.programmersbylocale.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.roberterrera.programmersbylocale.R;
import com.roberterrera.programmersbylocale.presenter.ActivityMethods;
import com.squareup.picasso.Picasso;

public class DetailActivity extends ActivityMethods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView platformLogo = (ImageView) findViewById(R.id.imageView_details_platform);
        TextView ageText = (TextView) findViewById(R.id.textView_details_age);
        TextView weightText = (TextView) findViewById(R.id.textView_details_weight);
        TextView faveColorText = (TextView) findViewById(R.id.textView_details_favecolor);
        TextView phoneText = (TextView) findViewById(R.id.textView_details_phone);
        TextView isAnArtistText = (TextView) findViewById(R.id.textView_details_artist);

        int age = getIntent().getIntExtra("age", -2);
        ageText.setText(String.format("%s%s",
                getString(R.string.ageLabel),
                String.valueOf(age)));

        double weight = getIntent().getDoubleExtra("weight", -1);
        weightText.setText(String.format("%s%s%s",
                getString(R.string.weightLabel),
                String.valueOf(weight),
                getString(R.string.weightLabelEnd)));

        boolean isArtist = getIntent().getBooleanExtra("artist", false);
        String isAnArtist;
        if (isArtist){
            isAnArtist = "Is an artist: Yes";
        } else isAnArtist = "Is an artist: No";
        isAnArtistText.setText(isAnArtist);

        String name = getIntent().getStringExtra("name");
        setTitle(name);

        String faveColor = getIntent().getStringExtra("color");
        faveColorText.setText(String.format("%s%s",
                getString(R.string.faveColorLabel),
                faveColor));

        String phoneNum = getIntent().getStringExtra("phone");
        phoneText.setText(String.format("%s%s",
                getString(R.string.phoneLabel),
                formatPhoneNumber(phoneNum)));

        String platform = getIntent().getStringExtra("platform");

        int appleLogo = R.drawable.applelogo;
        int androidLogo = R.drawable.androidlogo;
        int rubyLogo = R.drawable.rubylogo;

        if (platform != null) {
            switch (platform) {
                case "iOS":
                    Picasso.with(this)
                            .load(appleLogo)
                            .into(platformLogo);
                    break;
                case "Android":
                    Picasso.with(this)
                            .load(androidLogo)
                            .into(platformLogo);
                    break;
                case "Ruby":
                    Picasso.with(this)
                            .load(rubyLogo)
                            .into(platformLogo);
                    break;
            }
        }
    }
}
