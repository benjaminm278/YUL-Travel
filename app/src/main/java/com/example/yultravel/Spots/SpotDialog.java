package com.example.yultravel.Spots;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.yultravel.Database.Plan.Plan;
import com.example.yultravel.Database.Plan.PlanViewModel;
import com.example.yultravel.R;

public class SpotDialog {
    private Context ctx;
    private Dialog dialog;

    public SpotDialog(Context ctx) {
        this.ctx = ctx;
    }

    public void setSpotsDialog(final String title, final String description, final String link, final String address) {
        // Creates a new dialog object
        dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.spots_dialog);

        // Set contents of the dialog
        TextView titleDialog = dialog.findViewById(R.id.dialogTitle_TextView);
        titleDialog.setText(title);

        TextView descriptionDialog = dialog.findViewById(R.id.dialogDescription_TextView);
        descriptionDialog.setText(description);

        TextView a = dialog.findViewById(R.id.venueAddressTextView);
        a.setText(address);

        // Set size of dialog
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(layoutParams);

        // Add click listener to buttons in dialog
        dialog.findViewById(R.id.cancelButtonDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.findViewById(R.id.visitEventfulButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                ctx.startActivity(i);
            }
        });

        dialog.findViewById(R.id.bookmarkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Plan added", Toast.LENGTH_SHORT).show();

                // Create a plan object
                Plan p = new Plan(title, "Category", address, "12/05/2019",
                        "12:20 pm", true);
                // Store that plan object in the database
                PlanViewModel mPlanViewModel = ViewModelProviders.of((FragmentActivity) ctx)
                        .get(PlanViewModel.class);
                mPlanViewModel.insert(p);
            }
        });
    }

    public void openSpotsDialog() {
        dialog.show();
    }
}
