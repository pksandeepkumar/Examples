package sbl.com.andprocess.asynctask;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by sandeep on 23/3/16.
 */
public class TaskTwo extends AsyncTask<Void, Void, Void> {

    int count = 0;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public TaskTwo() {
    }

    @Override
    protected Void doInBackground(Void... params) {
        while (true && !isCancelled()) {
            Log.e("TaskTwo", "Task 2  executing:" + count++);
            try{
                Thread.sleep(1000);
            } catch ( Exception e) {
                Log.e("TaskTwo", "Excepetion:" + e.getMessage());
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}
