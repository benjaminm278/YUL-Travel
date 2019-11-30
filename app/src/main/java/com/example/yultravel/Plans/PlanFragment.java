package com.example.yultravel.Plans;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yultravel.R;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanFragment extends DialogFragment {
    static final String EXTRA_REPLY ="com.example.yultravel.REPLY";
    private EditText mActivityName;

    public PlanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_plan, container, false);
        mActivityName = v.findViewById(R.id.editTextActivityName);
        Button btn = (Button) v.findViewById(R.id.buttonAddPlanFrag);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(mActivityName.getText())){
                    getActivity().setResult(RESULT_CANCELED,replyIntent);
                }
                else {
                    String plan = mActivityName.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY,plan);
                    getActivity().setResult(RESULT_OK,replyIntent);
                }
                //getActivity().finish();
            }
        });
        Button btnCancel = v.findViewById(R.id.buttonCancelPlan);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dismiss();
            }
        });

        return v;
    }
}
