package texus.okhttpexample;


import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkTask extends AsyncTask<Void, Void, Void> {

    OkHttpClient client;
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	public NetworkTask() {
	}
	   
	@Override
	protected Void doInBackground(Void... params) {

        Log.e(MainActivity.TAG_LOG,"Calling1......");
        client = new OkHttpClient();
        try {
            Log.e(MainActivity.TAG_LOG,"Calling2......");
//            String resp = run("http://115.249.156.254/EDservicesfc/eDinette.asmx/Ping");
            String resp = run("http://google.com");
            Log.e(MainActivity.TAG_LOG,"Response:" + resp);
        } catch ( IOException e ) {e.printStackTrace();}

        return null;
	}

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
	}
}
