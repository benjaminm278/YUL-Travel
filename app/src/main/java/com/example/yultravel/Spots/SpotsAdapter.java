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
    static Context context;
    private LayoutInflater mInflater;
    private ArrayList<Spot> spotArrayList;

    public static class SpotsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        SpotsAdapter adapter;
        TextView title;
        String url;
        String description;

        public SpotsViewHolder(View itemView, SpotsAdapter adapter, Spot spot) {
            super(itemView);
            this.adapter = adapter;
            title = itemView.findViewById(R.id.titleOfSpot);
            description = spot.getDescription();

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Open dialog
            SpotDialog s = new SpotDialog(context);
            s.setSpotsDialog(title.getText().toString(), description, url);
            s.openSpotsDialog();
        }
    }

    /**
     *
     * @param context
     * @param spotArrayList
     */
    public SpotsAdapter(Context context, ArrayList<Spot> spotArrayList) {
        this.context = context;
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
        return new SpotsAdapter.SpotsViewHolder(mItemView,this, spotArrayList.get(i));
    }

    /**
     *
     * @param SpotsViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(SpotsAdapter.SpotsViewHolder SpotsViewHolder, int i) {
        SpotsViewHolder.title.setText(spotArrayList.get(i).getTitle());
        SpotsViewHolder.url = spotArrayList.get(i).getURL();
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
