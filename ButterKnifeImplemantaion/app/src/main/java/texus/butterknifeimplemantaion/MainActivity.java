package texus.butterknifeimplemantaion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btnSampleButton)
    Button btnSampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnSampleButton)
    public void showToast() {
        Toast.makeText(this,"Sample Message " , Toast.LENGTH_LONG).show();
        btnSampleButton.setText(btnSampleButton.getText() + " Clicked!!!");
    }
}
