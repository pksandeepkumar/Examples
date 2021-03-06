package sbl.com.andprocess.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by sandeep on 23/3/16.
 */
public class SampleServiceSecond extends Service {

    public static String PARAM_NAME = "name";

    private static final String TAG = "HelloService";

    private boolean isRunning  = false;
    private String serviceName = "";

    @Override
    public void onCreate() {
        Log.e(TAG, "Service onCreate");

        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


//

        serviceName = intent.getStringExtra(PARAM_NAME);

        //Creating new thread for my service
        //Always write your long running tasks in a separate thread, to avoid ANR
        new Thread(new Runnable() {
            @Override
            public void run() {


                //Your logic that service will perform will be placed here
                //In this example we are just looping and waits for 1000 milliseconds in each loop.
                for (int i = 0; i < 50; i++) {

                    Log.i(TAG, "Thread Running");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                    if(isRunning){
                        Log.i(TAG, "Service " + serviceName + " is running " + i);
                    }

//                    else {
//                        break;
//                    }
                }

                //Stop service once it finishes its task
//                stopSelf();
            }
        }).start();

        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;

        Log.i(TAG, "Service onDestroy");
    }
}
