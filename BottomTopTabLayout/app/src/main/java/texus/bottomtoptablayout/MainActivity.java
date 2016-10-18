package texus.bottomtoptablayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomTabControl bottomTabControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomTabControl = (BottomTabControl) findViewById(R.id.idBottomControl);
        bottomTabControl.setOnTabClickedListener(new BottomTabControl.OnTabClickedListener() {
            @Override
            public void onTabClicked(int whichTab) {
                Toast.makeText(MainActivity.this,"Tab:" + whichTab, Toast.LENGTH_LONG).show();
            }
        });


    }
}
