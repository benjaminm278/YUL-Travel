package com.example.yultravel.Spots;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yultravel.MainActivity;
import com.example.yultravel.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SpotsListAdapter extends RecyclerView.Adapter<SpotsListAdapter.SpotsListViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Spot> spotArrayList;
    Context ctx;

    public static class SpotsListViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        SpotsListAdapter adapter;
        TextView title;
        TextView description;
        TextView spotPosition;
        TextView link;
        Context ctx;

        public SpotsListViewHolder(Context ctx, View itemView, SpotsListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            title = itemView.findViewById(R.id.titleOfSpot);
            description = itemView.findViewById(R.id.eventDescriptionTextView);
            spotPosition = itemView.findViewById(R.id.positionOfSpotCardTextView);
            link = itemView.findViewById(R.id.linkTextView);
            this.ctx = ctx;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show();

            Dialog myDialog = new Dialog(ctx);
            myDialog.setContentView(R.layout.spots_dialog);

            TextView titleDialog = myDialog.findViewById(R.id.dialogTitle_TextView);
            titleDialog.setText(title.getText().toString());

            TextView descriptionDialog = myDialog.findViewById(R.id.dialogDescription_TextView);
            descriptionDialog.setText(description.getText().toString());

            myDialog.show();
        }
    }

    /**
     *
     * @param context
     * @param spotArrayList
     */
    public SpotsListAdapter(Context context, ArrayList<Spot> spotArrayList) {
        this.ctx = context;
        mInflater = LayoutInflater.from(context);
        this.spotArrayList = spotArrayList;
    }

    /**
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public SpotsListAdapter.SpotsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_item_spots_for_list, viewGroup,false);
        return new SpotsListAdapter.SpotsListViewHolder(ctx, mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull SpotsListViewHolder holder, int i) {
        holder.title.setText(spotArrayList.get(i).getTitle());
        holder.description.setText(spotArrayList.get(i).getDescription());
        holder.spotPosition.setText(i + 1 + "");
    }

    /**
     * Returns the size of the list
     * @return
     */
    @Override
    public int getItemCount() {
        return spotArrayList.size();
    }
}
