package com.campusiq.cereb_eplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_splash);

//        txt = findViewById(R.id.text);
//
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();


        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        // close splash activity
        finish();

    }

}