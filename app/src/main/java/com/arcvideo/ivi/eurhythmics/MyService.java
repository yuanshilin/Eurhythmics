package com.arcvideo.ivi.eurhythmics;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    private static final String TAG = "Eurhythmics";
    @Override
    public IBinder onBind(Intent intent) {
        // 如果服务不支持绑定，可以返回 null
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        // Start the service
        Log.d
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the service
    }
}
