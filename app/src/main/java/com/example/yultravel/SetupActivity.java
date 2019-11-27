package com.example.yultravel;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.yultravel.Database.Profile;
import com.example.yultravel.Database.ProfileViewModel;

import java.util.List;

public class SetupActivity extends AppCompatActivity {
    final private int numOfCheckBoxes = 5;
    private ProfileViewModel mProfileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        mProfileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        mProfileViewModel.getProfile().observe(this, new Observer<List<Profile>>() {
            @Override
            public void onChanged(List<Profile> profiles) {
                toast("Hello " + profiles.size() + "");
            }
        });

        Profile p = new Profile("Hippo", "");
        mProfileViewModel.insert(p);

        String[] arraySpinner = new String[] {
                "Canada", "USA", "China", "UK", "France", "Portugal", "Mexico"
        };

        Spinner s = findViewById(R.id.OriginSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void EnterParam(View view) {
        if (((EditText)findViewById(R.id.NameEdit)).getText().toString().isEmpty()){
            return;
        }

        String a = ((EditText) findViewById(R.id.NameEdit)).getText().toString();
        boolean[] checkBoxes = new boolean[this.numOfCheckBoxes];
        CheckBox[] cb = new CheckBox[this.numOfCheckBoxes];
        cb[0] = (CheckBox) findViewById(R.id.FoodCheck);
        cb[1] = (CheckBox) findViewById(R.id.NatureCheck);
        cb[2] = (CheckBox) findViewById(R.id.SightCheck);
        cb[3] = (CheckBox) findViewById(R.id.BoatsCheck);
        cb[4] = (CheckBox) findViewById(R.id.SportsCheck);

        for(int i = 0 ; i<this.numOfCheckBoxes;i++) {
            checkBoxes[i] = cb[i].isSelected();
        }

        Spinner spin = (Spinner) findViewById(R.id.OriginSpinner);
        //Profile p = new Profile("Hippo");
        //Toast.makeText(this, p.getName(), Toast.LENGTH_SHORT).show();
        //Profile pro = new Profile(this, (((EditText) findViewById(R.id.NameEdit)).getText().toString()), spin.getSelectedItem().toString(), checkBoxes);
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
