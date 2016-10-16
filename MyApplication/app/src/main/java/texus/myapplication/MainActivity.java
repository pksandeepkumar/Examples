package texus.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    int i = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        LinearLayout layout = new LinearLayout(this);
//        layout.setBackgroundColor(Color.RED);
//
//        setContentView(layout);

        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) this.findViewById(R.id.textView);

        final Button btnOne = (Button) this.findViewById(R.id.btn);

        Button btnTwo = (Button) this.findViewById(R.id.btn);

        btnOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText("Value changed " + i++);
                btnOne.setBackgroundResource(R.drawable.ic_calendar);

                Intent intent = new Intent(v.getContext(), Activity2.class);
                intent.putExtra("Param_name","Value");
                startActivity(intent);

//                Intent int1 = new Intent(Intent.ACTION_CALL);
//                int1.setData(Uri.parse("tel:8086017501"));
//                startActivity(int1);
            }

        });

    }

}
