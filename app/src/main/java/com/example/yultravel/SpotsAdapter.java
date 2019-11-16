package com.example.yultravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.Plans.Plan;

import java.util.ArrayList;

public class SpotsAdapter extends RecyclerView.Adapter<SpotsAdapter.SpotsViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Spot> spotArrayList;

    public static class SpotsViewHolder extends RecyclerView.ViewHolder{
        SpotsAdapter adapter;
        TextView title;
        SpotsViewHolder(View itemView, SpotsAdapter adapter) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewSpots);
            this.adapter =adapter;
        }
    }
    SpotsAdapter(Context context, ArrayList<Spot> spotArrayList) {
        mInflater = LayoutInflater.from(context);
        this.spotArrayList = spotArrayList;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @NonNull
    @Override
    public SpotsAdapter.SpotsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_item_spots, viewGroup,false);
        return new SpotsAdapter.SpotsViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(SpotsAdapter.SpotsViewHolder SpotsViewHolder, int i) {
        SpotsViewHolder.title.setText(spotArrayList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return spotArrayList.size();
    }


}
