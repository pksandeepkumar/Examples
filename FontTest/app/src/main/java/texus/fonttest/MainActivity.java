package texus.fonttest;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = ( TextView) this.findViewById( R.id.tvText);
    }

    public void setFont1( View view) {
        setFont("Sensei-Medium.otf");
    }

    public void setFont2( View view) {
        setFont("Sensei-Medium.ttf");
    }

    public void setFont3( View view) {
        setFont("Museo700-Regular.ttf");
    }

    public void setFont( String fontname) {
        try {
            Log.e("MainActivity","Font:" + fontname);
            Typeface face= Typeface.createFromAsset(getAssets(), "fonts/" + fontname);
            tv.setTypeface(face);
        } catch ( Exception e) {
            e.printStackTrace();;
            Toast.makeText(this,"Font:" + fontname + " cannot be set", Toast.LENGTH_LONG).show();
        }

    }
}
