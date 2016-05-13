package texus.okhttpexample;


import android.os.AsyncTask;
import android.widget.TextView;

public class NetworkTask2 extends AsyncTask<Void, Void, Void> {

    TextView tv;
    String response;


	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	public NetworkTask2(TextView tv) {
        this.tv = tv;
	}
	   
	@Override
	protected Void doInBackground(Void... params) {


        response = NetworkService.get("http://texusapps.com/AppXmls/MohanLalQuotes/quote_index.xml");

        return null;
	}


	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);

        tv.setText("" + response);

	}
}
