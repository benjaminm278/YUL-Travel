package com.example.yultravel.Spots;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.yultravel.R;

public class SpotDialog {
    private Context ctx;
    private Dialog dialog;

    public SpotDialog(Context ctx) {
        this.ctx = ctx;
    }

    public void setSpotsDialog(String title, String description) {
        // Creates a new dialog object
        dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.spots_dialog);

        // Set contents of the dialog
        TextView titleDialog = dialog.findViewById(R.id.dialogTitle_TextView);
        titleDialog.setText(title);

        TextView descriptionDialog = dialog.findViewById(R.id.dialogDescription_TextView);
        descriptionDialog.setText(description);

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
                // Retrieve link by opening intent
            }
        });

        dialog.findViewById(R.id.bookmarkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add bookmark
            }
        });
    }

    public void openSpotsDialog() {
        dialog.show();
    }
}
