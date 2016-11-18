package sbl.com.alarmmngrnetwrkoprations;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sbl.com.alarmmngrnetwrkoprations.alarm_manager.AlarmReceiver;
import sbl.com.alarmmngrnetwrkoprations.pojos.CurrencyValuePOJO;
import sbl.com.alarmmngrnetwrkoprations.pojos.Fields;
import sbl.com.alarmmngrnetwrkoprations.pojos.Meta;
import sbl.com.alarmmngrnetwrkoprations.pojos.Resource;
import sbl.com.alarmmngrnetwrkoprations.pojos.Resource_;
import sbl.com.alarmmngrnetwrkoprations.utilities.Utility;
import sbl.com.alarmmngrnetwrkoprations.webservice.ServiceGenerator;
import sbl.com.alarmmngrnetwrkoprations.webservice.WebAPI;

public class MainActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;
    LinearLayout llHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startAlarm();

    }

    public void getCurrenctyValue( View view) {
        Call<CurrencyValuePOJO> call = getServiceCall();
        call.enqueue(new Callback<CurrencyValuePOJO>() {
            @Override
            public void onResponse(Call<CurrencyValuePOJO> call,
                                   Response<CurrencyValuePOJO> response) {
                CurrencyValuePOJO object = response.body();
                if(object == null) return;
                sbl.com.alarmmngrnetwrkoprations.pojos.List list = object.getList();
                if( list == null) return;
                List<Resource> res = list.getResources();
                if( res == null) return;
                Fields indianField = null;
                for(Resource obj : res) {
                    Resource_ resource_ = obj.getResource();
                    Fields fields = resource_.getFields();
                    if(fields.getName().equals("USD/INR")) {
                        indianField = fields;
                        break;
                    }
                }
                if(indianField != null) {
                    Toast.makeText(MainActivity.this,"USD:" + indianField.getPrice(),
                            Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<CurrencyValuePOJO> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error:GetService" + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }

        });
    }

    public Call<CurrencyValuePOJO> getServiceCall() {
        WebAPI serviceApi =  ServiceGenerator.createService(WebAPI.class);
        Call<CurrencyValuePOJO> call = serviceApi.getCurrencyValues();
        return call;
    }

    public void logDb( View view) {
        llHolder = (LinearLayout) findViewById(R.id.llHolder);
        llHolder.removeAllViews();
        Databases db = new Databases(this);
        ArrayList<AlarmLogger> logger = AlarmLogger.getAllAlarmLogger(db);
        for(AlarmLogger object: logger) {
            TextView tv = new TextView(this);
            tv.setText(object.log_message + " @:" + getDateAndTime(object.dateAndTime));
            llHolder.addView(tv);
        }
        db.close();
    }

    public static String getDateAndTime(long milliSeconds) {
//        "2016-11-22 06:13:19.259148"; "YYYY-MM-DD HH:MM:SS"
        String dateFormat = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public void  clearDB( View view) {
        Databases db = new Databases(this);
        AlarmLogger.deleteTable(db);
        db.close();
    }

    public void startAlarm() {
        /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);

        start();

    }

    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 8000;
        manager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    }

    public void cancel() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    public void startAt10() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000 * 60 * 20;

        /* Set the alarm to start at 10:30 AM */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);

        /* Repeating on every 20 minutes interval */
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 20, pendingIntent);
    }


}
