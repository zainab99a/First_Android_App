package com.zainabali.yz.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SplashActivity extends Activity implements View.OnClickListener {
    LinearLayout mySplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        mySplash=findViewById(R.id.splash_screen);
        mySplash.setOnClickListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "you are on pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

        Intent myIntent= new Intent(this,MainActivity.class);
        startActivity(myIntent);

    }
}
