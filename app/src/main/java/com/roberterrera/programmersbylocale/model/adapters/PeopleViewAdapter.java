package com.roberterrera.programmersbylocale.model.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.roberterrera.programmersbylocale.R;

import java.util.List;

/**
 * Created by Rob on 8/13/16.
 */
public class PeopleViewAdapter extends RecyclerView.Adapter<PeopleViewHolder> {
    private Context context;
    private String name;
    private List<String> programmerNames;
    private ItemClickListener itemClickListener;

    public PeopleViewAdapter(List<String> people, Context context){
        this.programmerNames = people;
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
        name = programmerNames.get(position);

        holder.programmerName.setText(name);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //TODO: Set up a Map that holds the programmer position and their platform
                name = programmerNames.get(pos);
                Toast.makeText(context, "Tapped "+name, Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(context, DetailViewActivity.class);
//                intent.putExtra("name", name);
//                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return programmerNames.size();
    }
}
