package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableView;

    public void generateTimesTable(int timesTable) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {

            timesTableContent.add(Integer.toString(i * timesTable));

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTableView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTableView = findViewById(R.id.timesTableView);
        SeekBar timesTableSeekBar = findViewById(R.id.timesTableSeekBar);

        timesTableSeekBar.setMax(100);
        timesTableSeekBar.setProgress(10);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress < min) {
                    timesTable = min;
                } else {
                    timesTable = progress;
                }

                Log.i("SeekBar Clicked", Integer.toString(timesTable));

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        generateTimesTable(10);
    }
}
