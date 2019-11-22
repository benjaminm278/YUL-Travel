package com.example.yultravel.Directions;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoreDirectionsCategoryAdapter extends
        RecyclerView.Adapter<MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder>{
    public class MoreDirectionsCategoryViewHolder extends RecyclerView.ViewHolder {
        public MoreDirectionsCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        return null;
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
