package com.example.yultravel.Plans;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.Database.Plan.Plan;
import com.example.yultravel.R;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {
    final Context context;
    LayoutInflater mInflater;
    List<Plan> mPlans;

    public static class PlanViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        Context ctx;
        TextView title;
        TextView dateAndTime;

        public PlanViewHolder(View itemView, Context ctx) {
            super(itemView);
            title = itemView.findViewById(R.id.planNameTextView);
            dateAndTime = itemView.findViewById(R.id.planDateAndTimeTextView);
            this.ctx = ctx;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Open add plan activity
            Intent i = new Intent(ctx, AddPlanActivity.class);
            i.putExtra(PlansActivity.PLAN_OPERATION, "Edit");
            ctx.startActivity(i);
        }
    }

    /**
     * Default constructor for plan recyclerview
     * @param context
     */
    public PlanAdapter(Context context) {
        this.context = context;
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
        return new PlanViewHolder(mItemView, context);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder planViewHolder, int i) {
        planViewHolder.title.setText(mPlans.get(i).getTitle());
        planViewHolder.dateAndTime.setText(mPlans.get(i).getDate() + " at " + mPlans.get(i).getTime());
    }

    public void setPlans(List<Plan> plans){
        mPlans = plans;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mPlans != null) {
            return mPlans.size();
        }
        else {
            return 0;
        }
    }
}
