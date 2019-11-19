package com.example.yultravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = getString(R.string.user_name);
        TextView tv = findViewById(R.id.welcomeUser);
        String was = tv.getText().toString();
        tv.setText(was+" "+name);
    }

    public void goToHome(View view) {
        Intent intent =  new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }
}
