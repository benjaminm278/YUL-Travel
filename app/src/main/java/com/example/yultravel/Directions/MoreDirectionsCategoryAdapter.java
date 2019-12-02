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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.Database.Plan.Plan;
import com.example.yultravel.Database.Plan.PlanViewModel;
import com.example.yultravel.R;

import java.util.ArrayList;

public class MoreDirectionsCategoryAdapter extends
        RecyclerView.Adapter<MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder> {
    private LayoutInflater mInflater;
    private Context ctx;
    private ArrayList<Location> a;
    private FragmentManager mFragmentManager;

    /**
     *
     */
    public class MoreDirectionsCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ConstraintLayout locationConstraintLayout;
        TextView locationTxt;
        TextView addressTxt;
        TextView numberOnListTxt;
        Context ctx;

        public MoreDirectionsCategoryViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            locationConstraintLayout = itemView.findViewById(R.id.locationConstraintLayout);
            locationTxt = itemView.findViewById(R.id.locationNameTextView);
            addressTxt = itemView.findViewById(R.id.addressTextView);
            numberOnListTxt = itemView.findViewById(R.id.numberOnListTextView);
            this.ctx = ctx;

            itemView.setOnClickListener(this);
            itemView.findViewById(R.id.addToPlanImageButton).setOnClickListener(this);
            itemView.findViewById(R.id.getDirectionsImageButton).setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();

            switch (id) {
                case R.id.addToPlanImageButton:
                    TextView t = v.getRootView().findViewById(R.id.locationNameTextView);
                    String locName = t.getText().toString();

                    TextView t2 = v.getRootView().findViewById(R.id.addressTextView);
                    String address = t2.getText().toString();
                    addToPlans(locName, address, ctx);
                    break;
                default:
                    TextView t3 = v.getRootView().findViewById(R.id.addressTextView);
                    String address2 = t3.getText().toString();
                    openGoogleMaps(ctx, address2);
                    break;
            }
        }
    }

    /**
     * Adds plan to database
     */
    private void addToPlans(String location, String address, Context ctx) {
        Toast.makeText(ctx, "Plan added", Toast.LENGTH_SHORT).show();
        // Create a plan object
        Plan p = new Plan("Visit " + location, "Category", "", "12/01/2019",
                "12:20 pm", true);
        // Store that plan object in the database
        PlanViewModel mPlanViewModel = ViewModelProviders.of((FragmentActivity) ctx)
                .get(PlanViewModel.class);
        mPlanViewModel.insert(p);

        /*
        DialogFragment fragment = new PlanFragment();
        fragment.show(mFragmentManager, "");*/
    }

    /**
     * Opens Google Maps to show directions
     * @param ctx
     * @param address
     */
    private void openGoogleMaps(Context ctx, String address) {
        Uri addressUri = Uri.parse("geo:0,0?q=" + address);
        Intent i = new Intent(Intent.ACTION_VIEW, addressUri);
        ctx.startActivity(i);
    }

    /**
     *
     * @param ctx
     * @param a
     */
    public MoreDirectionsCategoryAdapter(Context ctx, FragmentManager f, ArrayList<Location> a) {
        mInflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.a = a;
        this.mFragmentManager = f;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.card_item_location, parent, false);
        return new MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder(mItemView, ctx);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder (@NonNull MoreDirectionsCategoryViewHolder holder, int position) {
        holder.locationTxt.setText(a.get(position).getName() + "");
        holder.addressTxt.setText(a.get(position).getAddress() + "");
        holder.numberOnListTxt.setText(position + 1 + "");
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return a.size();
    }
}
