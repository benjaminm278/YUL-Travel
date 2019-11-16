package com.example.yultravel.Spots;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import java.util.ArrayList;

public class SpotsAdapter extends RecyclerView.Adapter<SpotsAdapter.SpotsViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Spot> spotArrayList;

    public static class SpotsViewHolder extends RecyclerView.ViewHolder{
        SpotsAdapter adapter;
        TextView title;
        SpotsViewHolder(View itemView, SpotsAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            title = itemView.findViewById(R.id.titleOfSpot);
        }
    }

    /**
     *
     * @param context
     * @param spotArrayList
     */
    public SpotsAdapter(Context context, ArrayList<Spot> spotArrayList) {
        mInflater = LayoutInflater.from(context);
        this.spotArrayList = spotArrayList;
    }

    /**
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public SpotsAdapter.SpotsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_item_spots, viewGroup,false);
        return new SpotsAdapter.SpotsViewHolder(mItemView,this);
    }

    /**
     *
     * @param SpotsViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(SpotsAdapter.SpotsViewHolder SpotsViewHolder, int i) {
        SpotsViewHolder.title.setText(spotArrayList.get(i).getTitle());
    }

    /**
     * Returns the size of the list
     * @return
     */
    @Override
    public int getItemCount() {
        return spotArrayList.size();
    }


}
