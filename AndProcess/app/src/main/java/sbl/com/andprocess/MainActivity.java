package sbl.com.andprocess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");
    }

    public void showServiceActivity( View view) {
        Intent intent = new Intent(this,ServiceActivity.class);
        startActivity(intent);
    }

    public void showAsyncTaskActivity( View view) {
        Intent intent = new Intent(this,AsyncTaskActivity.class);
        startActivity(intent);
    }

    public void showIntentServiceActivity( View view) {
        Intent intent = new Intent(this,IntentServiceActivity.class);
        startActivity(intent);
    }

    public void showThreadActivity( View view) {
        Intent intent = new Intent(this,ThreadActivity.class);
        startActivity(intent);
    }

    public void showRotateActivity( View view) {
        Intent intent = new Intent(this,RotateActivity.class);
        startActivity(intent);
    }

    public void showHandlerActivity( View view) {
        Intent intent = new Intent(this,HandlerActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }
}
