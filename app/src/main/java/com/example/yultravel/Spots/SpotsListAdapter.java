package com.example.yultravel.Spots;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SpotsListAdapter extends RecyclerView.Adapter<SpotsListAdapter.SpotsListViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Spot> spotArrayList;

    public static class SpotsListViewHolder extends RecyclerView.ViewHolder{
        SpotsListAdapter adapter;
        TextView title;
        TextView description;
        TextView spotPosition;
        TextView link;

        public SpotsListViewHolder(View itemView, SpotsListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            title = itemView.findViewById(R.id.titleOfSpot);
            description = itemView.findViewById(R.id.eventDescriptionTextView);
            spotPosition = itemView.findViewById(R.id.positionOfSpotCardTextView);
            link = itemView.findViewById(R.id.linkTextView);
        }
    }

    /**
     *
     * @param context
     * @param spotArrayList
     */
    public SpotsListAdapter(Context context, ArrayList<Spot> spotArrayList) {
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
    public SpotsListAdapter.SpotsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_item_spots_for_list, viewGroup,false);
        return new SpotsListAdapter.SpotsListViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull SpotsListViewHolder holder, int i) {
        holder.title.setText(spotArrayList.get(i).getTitle());
        holder.description.setText(spotArrayList.get(i).getDescription());
        holder.spotPosition.setText(i + 1 + "");
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
