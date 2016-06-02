package texus.vollyexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyTag";

    EditText etrequestURL;
    TextView tvResponse;
    Button btnCancel;
    Button btnRequest;

    // Instantiate the RequestQueue.
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        initViews();
    }

    public void initViews() {
        etrequestURL = (EditText) this.findViewById(R.id.etrequestURL);
        etrequestURL.setText("http://api.geonames.org/findNearbyJSON?lat=47.3&lng=9&username=akhiljayaram&radius=300");
        tvResponse = (TextView) this.findViewById(R.id.tvResponse);
        btnCancel = (Button) this.findViewById(R.id.btnCancel);
        btnRequest = (Button) this.findViewById(R.id.btnRequest);
    }

    public void doRequest( View view) {

        String url = etrequestURL.getText().toString().trim();

        tvResponse.setText("Sending Request....");

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tvResponse.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvResponse.setText("That didn't work!");
            }

        });

        stringRequest.setTag(TAG);
        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    public void doCancel( View view) {
        queue.cancelAll(TAG);
        tvResponse.setText("Cancelling....");

    }
}
