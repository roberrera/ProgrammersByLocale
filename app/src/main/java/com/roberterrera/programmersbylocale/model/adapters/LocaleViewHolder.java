package com.roberterrera.programmersbylocale.model.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roberterrera.programmersbylocale.R;

/**
 * Created by Rob on 8/13/16.
 */
public class LocaleViewHolder extends RecyclerView.ViewHolder{

    TextView locationName;
    ImageView locationPhoto;

    private Context context;

    public LocaleViewHolder(View itemView) {
        super(itemView);
        locationName = (TextView) itemView.findViewById(R.id.textview_locale_name);
        locationPhoto = (ImageView) itemView.findViewById(R.id.imageview_locale_photo);

        context = itemView.getContext();

    }
}
