package texus.okhttpexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_LOG = "OkHttp Main";

    OkHttpClient client;

    @Bind(R.id.btnNetworkOperation)
    Button btnNetworkOperation;

    @Bind(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    public void doNetworkOperation( View view) {
        NetworkTask2 task = new NetworkTask2(tvResult);
        task.execute();

    }


}
