package sbl.com.andprocess;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import sbl.com.andprocess.services.SampleService;
import sbl.com.andprocess.services.SampleServiceSecond;

public class ServiceActivity extends AppCompatActivity {

    Intent firstIntent;
    Intent secondIntent;

    SampleService sampleService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        setTitle(R.string.service);
    }

    public void startService( View view) {
        firstIntent = new Intent(this, SampleService.class);
        firstIntent.putExtra(SampleService.PARAM_NAME, "First");
        startService(firstIntent);
        bindService(firstIntent, mServiceConnection, Context.BIND_AUTO_CREATE);


    }



    public void getCount( View view) {
        TextView tv = (TextView)findViewById(R.id.tvText);
        tv.setText("" + sampleService.getCount());
    }

    public void stopService( View view) {
        stopService(firstIntent);
    }

    public void startServiceSecond( View view) {
        secondIntent = new Intent(this, SampleServiceSecond.class);
        secondIntent.putExtra(SampleService.PARAM_NAME,"Second");
        startService(secondIntent);

    }

    public void stopServiceSecond( View view) {
        stopService(secondIntent);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
//            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SampleService.MyBinder myBinder = (SampleService.MyBinder) service;
            sampleService = myBinder.getService();
//            mServiceBound = true;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(firstIntent);
    }
}
