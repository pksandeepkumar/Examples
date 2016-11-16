package sbl.com.alarmmngrnetwrkoprations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import sbl.com.alarmmngrnetwrkoprations.utilities.Utility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CDSAQuestions result = getParse(Utility.readFromAssets(
                "resp.txt", this
        ));
        if(result != null) {
            result.getStatus();
            Message msg = result.getMessage();
            msg.getTitle();
            List<FormField> formFieldList = msg.getFormFields();
            for( FormField obj: formFieldList) {
                obj.getFieldName();
            }
        }

    }

    public CDSAQuestions getParse(String response) {
        Gson gson = new GsonBuilder().create();
        CDSAQuestions object = gson.fromJson(response, CDSAQuestions.class);
        return object;
    }
}
