package com.example.yultravel.Spots;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yultravel.R;

public class SpotDialog {
    private Context ctx;
    private Dialog dialog;

    public SpotDialog(Context ctx) {
        this.ctx = ctx;
    }

    public void setSpotsDialog(String title, final String description, final String link, String address) {
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
                Toast.makeText(ctx, "Click to eventful.com", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                ctx.startActivity(i);
            }
        });

        dialog.findViewById(R.id.bookmarkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add bookmark
                Toast.makeText(ctx, "Click to bookmark", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openSpotsDialog() {
        dialog.show();
    }
}
