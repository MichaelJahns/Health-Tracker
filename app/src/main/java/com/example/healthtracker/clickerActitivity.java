package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class clickerActitivity extends AppCompatActivity {
    public int clicks;
    public TextView counter;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker_actitivity);
    }

    public void onClickerZoneClick(View view){
        counter = findViewById(R.id.clickerCounter);
        button = findViewById(R.id.clickerZone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                counter.setText(String.valueOf(clicks));
            }
        });
    }
}
