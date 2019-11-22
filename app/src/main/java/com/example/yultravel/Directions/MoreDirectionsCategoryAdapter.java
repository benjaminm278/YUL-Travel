package com.example.yultravel.Directions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MoreDirectionsCategoryAdapter extends
        RecyclerView.Adapter<MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder> {
    private LayoutInflater mInflater;
    private Context ctx;
    private ArrayList<Location> a;

    /**
     *
     */
    public class MoreDirectionsCategoryViewHolder extends RecyclerView.ViewHolder {
        TextView locationTxt;
        TextView addressTxt;
        TextView numberOnListTxt;

        public MoreDirectionsCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            locationTxt = itemView.findViewById(R.id.locationNameTextView);
            addressTxt = itemView.findViewById(R.id.addressTextView);
            numberOnListTxt = itemView.findViewById(R.id.numberOnListTextView);
        }
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
        return new MoreDirectionsCategoryAdapter.MoreDirectionsCategoryViewHolder(mItemView);
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
