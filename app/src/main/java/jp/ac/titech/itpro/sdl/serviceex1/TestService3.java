package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class TestService3 extends Service {
    private final static String TAG = "TestService3";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand in " + Thread.currentThread());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent broadcastIntent = new Intent();
                broadcastIntent.putExtra(
                        "message", "Hello, from testService3 by BroadCast!");
                broadcastIntent.setAction("ACTION_SERVICE3");
                getBaseContext().sendBroadcast(broadcastIntent);
            }
        }, 3000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
