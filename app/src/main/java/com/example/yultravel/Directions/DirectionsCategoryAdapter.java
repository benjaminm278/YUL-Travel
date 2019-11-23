package com.example.yultravel.Directions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import java.util.ArrayList;

public class DirectionsCategoryAdapter extends RecyclerView.Adapter<DirectionsCategoryAdapter.DirectionsCategoryViewHolder> {
    private ArrayList<String> category_names;
    private LayoutInflater mInflater;
    private Context ctx;

    public static final String CATEGORY_EXTRA = "com.example.yultravel.Directions.category.EXTRA";

    public static class DirectionsCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView categoryTxt;
        DirectionsCategoryAdapter adapter;
        public DirectionsCategoryViewHolder(@NonNull View itemView, DirectionsCategoryAdapter adapter) {
            super(itemView);

            this.adapter = adapter;
            categoryTxt = itemView.findViewById(R.id.nameTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            adapter.openMoreDirectionsActivity(categoryTxt.getText().toString());
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
        this.ctx = ctx;
    }

    /**
     *
     * @param category
     */
    private void openMoreDirectionsActivity(String category) {
        Intent i = new Intent(ctx, MoreDirectionsActivity.class);
        i.putExtra(CATEGORY_EXTRA, category);
        ctx.startActivity(i);
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
        View mItemView = mInflater.inflate(R.layout.directions_category, parent,false);
        return new DirectionsCategoryAdapter.DirectionsCategoryViewHolder(mItemView, this);
    }

    /**
     * Sets the text of a textview at a given position
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull DirectionsCategoryViewHolder holder, int position) {
        holder.categoryTxt.setText(category_names.get(position) + " ");
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
