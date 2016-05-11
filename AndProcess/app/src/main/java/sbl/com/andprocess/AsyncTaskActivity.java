package sbl.com.andprocess;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import sbl.com.andprocess.asynctask.TaskOne;
import sbl.com.andprocess.asynctask.TaskTwo;


public class AsyncTaskActivity extends AppCompatActivity {

    TaskOne taskOne;
    TaskTwo taskTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Async Task");
    }

    public void startTaskOne( View view) {
        taskOne = new TaskOne();
        //Excecuting multiple asynctask at a time
        taskOne.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void startTaskTwo( View view) {
        taskTwo = new TaskTwo();
        taskTwo.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void stopTaskOne( View view) {
        if( taskOne == null ) return;
        if(taskOne.isCancelled()) {
            Toast.makeText(this,"Task One Is cancelled",Toast.LENGTH_LONG).show();
            return;
        }
        taskOne.cancel(true);
    }

    public void stopTaskTwo( View view) {
        if( taskTwo == null ) return;
        if(taskTwo.isCancelled()) {
            Toast.makeText(this,"Task Two Is cancelled",Toast.LENGTH_LONG).show();
            return;
        }
        taskTwo.cancel(true);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("AsyncTaskActivity","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("AsyncTaskActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("AsyncTaskActivity", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("AsyncTaskActivity", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("AsyncTaskActivity", "onStop");
    }
}
