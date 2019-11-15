package com.example.yultravel.Plans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Plan> planArrayList;

    public static class PlanViewHolder extends RecyclerView.ViewHolder{
        PlanAdapter adapter;
        TextView title;
         PlanViewHolder( View itemView, PlanAdapter adapter) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewPlan);
            this.adapter =adapter;
        }
    }
    PlanAdapter(Context context, ArrayList<Plan> planArrayList) {
        mInflater = LayoutInflater.from(context);
        this.planArrayList = planArrayList;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_item_plan,viewGroup,false);
        return new PlanViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder planViewHolder, int i) {
            planViewHolder.title.setText(planArrayList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return planArrayList.size();
    }


}
