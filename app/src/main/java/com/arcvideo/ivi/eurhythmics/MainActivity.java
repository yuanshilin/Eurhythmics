package com.arcvideo.ivi.eurhythmics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.arcvideo.ivi.light.musical.Factory;
import com.arcvideo.ivi.light.musical.Listener;
import com.arcvideo.ivi.light.musical.Visualizer;
import com.arcvideo.ivi.light.musical.VisualizerType;
import com.arcvideo.ivi.light.utils.RGB;
import com.tencent.mars.xlog.Log;
import android.widget.Button;

import com.arcvideo.ivi.light.utils.MarsLog;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_RECORD_AUDIO = 0X01;
    private Button btnStart;
    private Button btnStop;

    private Visualizer visualizer;

    private static final String TAG = "Eurhythmics";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarsLog.init("","",7);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);


            if (checkSelfPermission(android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "requestPermissions RECORD_AUDIO");
                requestPermissions(new String[]{android.Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO);
            }

            if (checkSelfPermission(android.Manifest.permission.MODIFY_AUDIO_SETTINGS) != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "requestPermissions MODIFY_AUDIO_SETTINGS");
                requestPermissions(new String[]{Manifest.permission.MODIFY_AUDIO_SETTINGS}, REQUEST_RECORD_AUDIO);
            }




        btnStart.setOnClickListener(v -> {
            // Start the service
            Log.d(TAG, "Start the service");
            if(visualizer == null) {
                visualizer = Factory.create(VisualizerType.NATIVE, 0, new Listener() {
                    @Override
                    public void onColor(RGB rgb) {
                        Log.d(TAG, "onColor: " + rgb);
                    }
                });


            }
        });

        btnStop.setOnClickListener(v -> {
            // Stop the service
            Log.d(TAG, "Stop the service");
            if (visualizer != null) {
                visualizer.destroy();
                visualizer = null;
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_RECORD_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e(TAG, "onRequestPermissionsResult RECORD_AUDIO");
            }
        }
    }
}