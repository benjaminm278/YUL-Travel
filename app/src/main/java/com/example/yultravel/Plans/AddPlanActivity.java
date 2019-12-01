package com.example.yultravel.Plans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yultravel.Database.Plan;
import com.example.yultravel.Database.PlanViewModel;
import com.example.yultravel.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPlanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String currentActivityType;
    private String date;
    private TextView dateTxtView;
    private TextView timeTxtView;
    public final String DATE_PICKER_TAG = "datePicker";
    public final String TIME_PICKER_TAG = "timePicker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        // Spinner code
        Spinner s = findViewById(R.id.activityTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s.setAdapter(adapter);

        if (s != null) {
            s.setOnItemSelectedListener(this);
        }

        dateTxtView = findViewById(R.id.dateTextView);
        timeTxtView = findViewById(R.id.timeTextView);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        currentActivityType = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    /**
     * Adds plan to database after verification
     * @param view
     */
    public void addPlan(View view) {
        // Get plan details
        EditText e = findViewById(R.id.nameEditText);
        String name = e.getText().toString();

        EditText locationEditTxt = findViewById(R.id.locationEditText);
        String location = locationEditTxt.getText().toString();

        String date = dateTxtView.getText().toString();
        String time = timeTxtView.getText().toString();

        // Verify if plan details are valid
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(location) || TextUtils.isEmpty(date)
            || TextUtils.isEmpty(time)) {
            Toast.makeText(this, "All fields must be filled to create a plan!",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            // Valid
            PlanViewModel mPlanViewModel = ViewModelProviders.of(this)
                    .get(PlanViewModel.class);
            mPlanViewModel.insert(new Plan(name, currentActivityType, "", "12/01/2019",
                    "", true));
            finish();
        }
    }

    public void processDatePickerResult(int year, int month, int day) {
        // Converts integers to strings
        String month_str = Integer.toString(month+1); // Internally month starts at 0
        String day_str = Integer.toString(day);
        String year_str = Integer.toString(year);

        // Formats message to be displayed
        String date_msg = day_str + "/" + month_str + "/" + year_str;

        // Displays message
        Log.d("bangbang", date_msg);

        // Add date to object
        SimpleDateFormat currentFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj;
        String newDateFormat = "";

        try {
            dateObj = currentFormat.parse(date_msg);
            SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, yyyy");
            newDateFormat = newFormat.format(dateObj);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        date = newDateFormat;
        dateTxtView.setText(date);
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        String ampm;
        if (hourOfDay < 12) {
            ampm = "AM";
        }
        else {
            hourOfDay -= 12;
            ampm = "PM";
        }
        String hour = "" + hourOfDay;

        String min = "";
        if (minute < 10) {
            min = "0";
        }
        min += minute;

        String time = hour + ":" + min + " " + ampm;

        Log.d("bangbang", time);

        timeTxtView.setText(time);
    }

    public void openFragment(View view) {
        DialogFragment d;

        switch (view.getId()) {
            case R.id.chooseDateButton:
                d = new DatePickerFragment();
                d.show(getSupportFragmentManager(), DATE_PICKER_TAG);
                break;
            case R.id.chooseTimeButton:
                d = new TimePickerFragment();
                d.show(getSupportFragmentManager(), TIME_PICKER_TAG);
                break;
        }
    }

    public void closeAddPlanActivity(View view) {
        finish();
    }
}
