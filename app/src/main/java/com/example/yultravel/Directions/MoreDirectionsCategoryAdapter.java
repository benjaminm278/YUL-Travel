package com.example.yultravel.Directions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import java.util.ArrayList;

public class MoreDirectionsCategoryAdapter extends
        RecyclerView.Adapter<MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder> {
    private LayoutInflater mInflater;
    private Context ctx;
    private ArrayList<Location> a;

    /**
     *
     */
    public class MoreDirectionsCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView locationTxt;
        TextView addressTxt;
        TextView numberOnListTxt;
        Context ctx;

        public MoreDirectionsCategoryViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            locationTxt = itemView.findViewById(R.id.locationNameTextView);
            addressTxt = itemView.findViewById(R.id.addressTextView);
            numberOnListTxt = itemView.findViewById(R.id.numberOnListTextView);
            this.ctx = ctx;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            openGoogleMaps(ctx);
        }
    }

    private void openGoogleMaps(Context ctx) {
        Uri addressUri = Uri.parse("geo:0,0?q=Montreal");
        Intent i = new Intent(Intent.ACTION_VIEW, addressUri);
        ctx.startActivity(i);
    }

    /**
     *
     * @param ctx
     * @param a
     */
    public MoreDirectionsCategoryAdapter(Context ctx, ArrayList<Location> a) {
        mInflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
        this.a = a;
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
