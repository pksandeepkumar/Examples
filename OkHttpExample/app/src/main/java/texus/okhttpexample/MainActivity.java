package texus.okhttpexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_LOG = "OkHttp Main";

    OkHttpClient client;

    @Bind(R.id.btnNetworkOperation)
    Button btnNetworkOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void doNetworkOperation( View view) {
        NetworkTask task = new NetworkTask();
        task.execute();

    }


}
