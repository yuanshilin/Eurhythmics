package com.arcvideo.ivi.eurhythmics;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mars.xlog.Log;

import com.arcvideo.ivi.light.musical.Factory;
import com.arcvideo.ivi.light.musical.Listener;
import com.arcvideo.ivi.light.musical.NativeVisualizer;
import com.arcvideo.ivi.light.musical.Visualizer;
import com.arcvideo.ivi.light.musical.VisualizerType;
import com.arcvideo.ivi.light.utils.RGB;


public class MyService extends Service {

    private static final String TAG = "Eurhythmics";

    private Visualizer _visualizer;
    @Override
    public IBinder onBind(Intent intent) {
        // 如果服务不支持绑定，可以返回 null
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        // Start the service
        Log.d(TAG, "onCreate the service");
        if (_visualizer == null) {
            _visualizer  = Factory.create(VisualizerType.NATIVE, 0, new Listener() {
                @Override
                public void onColor(RGB rgb) {
                    Log.d(TAG, "onColor: " + rgb);
                }
            });;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the service
        Log.d(TAG, "onDestroy the service");
        if (_visualizer != null) {
            _visualizer.destroy();
            _visualizer = null;
        }
    }
}
