package com.roberterrera.programmersbylocale.model.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roberterrera.programmersbylocale.PeopleViewActivity;
import com.roberterrera.programmersbylocale.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rob on 8/13/16.
 */
public class LocaleViewAdapter extends RecyclerView.Adapter<LocaleViewHolder> {
    private Context context;
    private String locality;
    private List<String> programmerLocations;
    private ItemClickListener itemClickListener;

    public LocaleViewAdapter(List<String> locationsList, Context context){
        this.programmerLocations = locationsList;
        this.context = context;
    }

    @Override
    public LocaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.locale_view_layout, parent, false);

        return new LocaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocaleViewHolder holder, int position) {
        locality = programmerLocations.get(position);
        int nycSkyLine = R.drawable.nycskyline;
        int chicagoSkyline = R.drawable.chicagoskyline;
        int oaklandPort = R.drawable.oaklandport;

        /* Change background image based on location from JSON data */
        if (locality != null) {

            holder.locationName.setText(locality);

            switch (locality) {
                case "New York":
                    Picasso.with(context)
                            .load(nycSkyLine)
                            .into(holder.locationPhoto);
                    break;
                case "Chicago":
                    Picasso.with(context)
                            .load(chicagoSkyline)
                            .into(holder.locationPhoto);
                    break;
                case "Oakland":
                    Picasso.with(context)
                            .load(oaklandPort)
                            .into(holder.locationPhoto);
                    break;
            }
        } else {
            holder.locationName.setText("Null :(");
            Picasso.with(context)
                    .load(R.drawable.nycskyline)
                    .into(holder.locationPhoto);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                locality = programmerLocations.get(pos);

                Intent intent = new Intent(context, PeopleViewActivity.class);
                intent.putExtra("locality", locality);
                intent.putExtra("locality pos", pos);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return programmerLocations.size();
    }
}
