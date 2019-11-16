package com.example.yultravel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DirectionsCategoryAdapter extends RecyclerView.Adapter<DirectionsCategoryAdapter.DirectionsCategoryViewHolder> {
    private ArrayList<String> category_names;
    private LayoutInflater mInflater;

    public static class DirectionsCategoryViewHolder extends RecyclerView.ViewHolder {
        final TextView categoryTxt;
        public DirectionsCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTxt = itemView.findViewById(R.id.categoryTextView);
        }
    }

    /**
     * Sets variables of adapter
     * @param ctx
     * @param category_names
     */
    public DirectionsCategoryAdapter(Context ctx, ArrayList<String> category_names) {
        mInflater = LayoutInflater.from(ctx);
        this.category_names = category_names;
    }

    /**
     * Creates a viewholder
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public DirectionsCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.category_cardview, parent,false);
        return new DirectionsCategoryAdapter.DirectionsCategoryViewHolder(mItemView);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull DirectionsCategoryViewHolder holder, int position) {
        //holder.categoryTxt.setText(category_names.get(position) + " ");
    }

    /**
     * Returns the size of the list
     * @return
     */
    @Override
    public int getItemCount() {
        return category_names.size();
    }
}
