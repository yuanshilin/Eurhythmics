package com.arcvideo.ivi.eurhythmics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.tencent.mars.xlog.Log;
import android.widget.Button;

import com.arcvideo.ivi.light.utils.MarsLog;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnStop;

    private static final String TAG = "Eurhythmics";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarsLog.init("","",7);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(v -> {
            // Start the service
            Log.d(TAG, "Start the service");
        });

        btnStop.setOnClickListener(v -> {
            // Stop the service
            Log.d(TAG, "Stop the service");
        });
    }
}