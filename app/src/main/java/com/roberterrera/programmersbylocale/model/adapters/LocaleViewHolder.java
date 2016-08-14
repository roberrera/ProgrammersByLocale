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
public class LocaleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView locationName;
    public ImageView locationPhoto;

    private ItemClickListener itemClickListener;
    private Context context;

    public LocaleViewHolder(View itemView) {
        super(itemView);
        locationName = (TextView) itemView.findViewById(R.id.textview_locale_name);
        locationPhoto = (ImageView) itemView.findViewById(R.id.imageview_locale_photo);

        context = itemView.getContext();
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
}
