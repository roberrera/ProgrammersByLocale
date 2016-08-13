package com.roberterrera.programmersbylocale.model.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roberterrera.programmersbylocale.R;
import com.roberterrera.programmersbylocale.model.ProgrammerLocation;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Rob on 8/13/16.
 */
public class LocaleViewAdapter extends RecyclerView.Adapter<LocaleViewAdapter.LocaleViewHolder> {
    private Context context;
    private String locality;
    private List<ProgrammerLocation> programmerLocations;

    public LocaleViewAdapter(List<ProgrammerLocation> locationsList, Context context){
        this.programmerLocations = locationsList;
        this.context = context;
    }

    @Override
    public LocaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.locale_view_layout, parent, false);
        LocaleViewHolder viewHolder = new LocaleViewHolder(view);
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, PeopleViewActivity.class);
//                intent.putExtra("locality", locality);
                Toast.makeText(context, "Tapped "+locality, Toast.LENGTH_SHORT).show();
//                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LocaleViewHolder holder, int position) {
        locality = programmerLocations.get(position).getLocality();
        int nycSkyLine = R.drawable.nycskyline;
        int chicagoSkyline = R.drawable.chicagoskyline;
        int oaklandPort = R.drawable.oaklandport;

        // Change background image based on location
        holder.locationName.setText(locality);
        switch (locality) {
            case "New York":
                Picasso.with(context)
                        .load(nycSkyLine)
                        .centerCrop()
                        .into(holder.locationPhoto);
                break;
            case "Chicago":
                Picasso.with(context)
                        .load(chicagoSkyline)
                        .centerCrop()
                        .into(holder.locationPhoto);
                break;
            case "Oakland":
                Picasso.with(context)
                        .load(oaklandPort)
                        .centerCrop()
                        .into(holder.locationPhoto);
                break;
        }
    }

    public static class LocaleViewHolder extends RecyclerView.ViewHolder {
        private Context context;

        @BindView(R.id.layout_cardview) View layout;
        @BindView(R.id.textview_locale_name) TextView locationName;
        @BindView(R.id.imageview_locale_photo)ImageView locationPhoto;

        public LocaleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            context = itemView.getContext();
        }
    }

    @Override
    public int getItemCount() {
        return programmerLocations.size();
    }
}
