package texus.fonttest;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
        setFont("JLSSpaceGothicR_NC.otf");
    }

    public void setFont( String fontname) {
        Typeface face= Typeface.createFromAsset(getAssets(), "font/" + fontname);
        tv.setTypeface(face);
    }
}
