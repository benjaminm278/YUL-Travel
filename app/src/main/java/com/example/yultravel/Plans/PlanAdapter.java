package com.example.yultravel.Plans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.Database.Plan;
import com.example.yultravel.R;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {

    LayoutInflater mInflater;
    List<Plan> mPlans;

    public static class PlanViewHolder extends RecyclerView.ViewHolder{

        TextView title;
         PlanViewHolder( View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewPlan);

        }
    }
    PlanAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_item_plan,viewGroup,false);
        return new PlanViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder planViewHolder, int i) {
            planViewHolder.title.setText(mPlans.get(i).getTitle());
    }
    void setPlans(List<Plan> plans){
        mPlans = plans;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mPlans!=null)
        return mPlans.size();
        else return 0;
    }


}
