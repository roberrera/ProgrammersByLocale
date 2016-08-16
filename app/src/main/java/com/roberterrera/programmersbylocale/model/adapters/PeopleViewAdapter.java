package com.roberterrera.programmersbylocale.model.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.roberterrera.programmersbylocale.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rob on 8/13/16.
 */
public class PeopleViewAdapter extends RecyclerView.Adapter<PeopleViewHolder> {

    private String name, platform;
    private List<String> programmerNames, platformList;

    private Context context;

    public PeopleViewAdapter(List<String> programmerNames, List<String> platformList, Context context){
        this.programmerNames = programmerNames;
        this.platformList = platformList;
        this.context = context;
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.people_view_layout, parent, false);

        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        int appleLogo = R.drawable.applelogo;
        int androidLogo = R.drawable.androidlogo;
        int rubyLogo = R.drawable.rubylogo;

        name = programmerNames.get(position);
        platform = platformList.get(position);
        holder.programmerNameTextView.setText(name);

        /* Change background image based on platform associated with the programmer. */
        if (platform != null) {
            switch (platform) {
                case "iOS":
                    Picasso.with(context)
                            .load(appleLogo)
                            .into(holder.platformLogo);
                    break;
                case "Android":
                    Picasso.with(context)
                            .load(androidLogo)
                            .into(holder.platformLogo);
                    break;
                case "Ruby":
                    Picasso.with(context)
                            .load(rubyLogo)
                            .into(holder.platformLogo);
                    break;
            }
        } else {
            holder.programmerNameTextView.setText(R.string.nullString);
            Picasso.with(context)
                    .load(R.drawable.nycskyline)
                    .into(holder.platformLogo);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //TODO: Create intent to DetailActivity and display details about the Programmer from selected row.
                name = programmerNames.get(pos);
                Toast.makeText(context, "Name: "+name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return programmerNames.size();
    }
}
