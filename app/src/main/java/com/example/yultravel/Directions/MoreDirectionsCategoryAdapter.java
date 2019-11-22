package com.example.yultravel.Directions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import java.util.ArrayList;

public class MoreDirectionsCategoryAdapter extends
        RecyclerView.Adapter<MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder> {
    private LayoutInflater mInflater;
    private Context ctx;

    public class MoreDirectionsCategoryViewHolder extends RecyclerView.ViewHolder {
        public MoreDirectionsCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public MoreDirectionsCategoryAdapter(Context ctx, ArrayList<Location> a) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.card_item_location, parent, false);
        return new MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder
            (@NonNull MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder holder,
             int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
