package com.example.yultravel;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);


        String[] arraySpinner = new String[] {
                "Canada", "USA", "China", "UK", "France", "Portugal", "Mexico"
        };
        Spinner s = (Spinner) findViewById(R.id.OriginSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void EnterParam(View view) {
        if (((EditText)findViewById(R.id.NameEdit)).getText().toString().isEmpty()){
            invalidToast();
            return;
        }
       // Profile pro = new Profile((((EditText) findViewById(R.id.NameEdit)).getText().toString()), );

    }

    private void invalidToast(){
        Toast.makeText(this, "field empty :(", Toast.LENGTH_SHORT).show();
    }
}
