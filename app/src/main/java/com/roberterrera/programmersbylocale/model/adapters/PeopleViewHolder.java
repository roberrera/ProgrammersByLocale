package com.roberterrera.programmersbylocale.model.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.roberterrera.programmersbylocale.R;

/**
 * Created by Rob on 8/14/16.
 */
public class PeopleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView programmerName;

    private ItemClickListener itemClickListener;
    private Context context;

    public PeopleViewHolder(View itemView) {
        super(itemView);

        programmerName = (TextView) itemView.findViewById(R.id.textview_programmer_name);

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
