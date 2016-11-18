package sbl.com.alarmmngrnetwrkoprations.alarm_manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sbl.com.alarmmngrnetwrkoprations.AlarmLogger;
import sbl.com.alarmmngrnetwrkoprations.Databases;
import sbl.com.alarmmngrnetwrkoprations.MainActivity;
import sbl.com.alarmmngrnetwrkoprations.pojos.CurrencyValuePOJO;
import sbl.com.alarmmngrnetwrkoprations.pojos.Fields;
import sbl.com.alarmmngrnetwrkoprations.pojos.Resource;
import sbl.com.alarmmngrnetwrkoprations.pojos.Resource_;
import sbl.com.alarmmngrnetwrkoprations.webservice.ServiceGenerator;
import sbl.com.alarmmngrnetwrkoprations.webservice.WebAPI;

/**
 * Created by sandeep on 11/17/2016.
 */

public class AlarmReceiver extends BroadcastReceiver {

    Context mContext = null;

    //The intraval in milliseconds
    public static int interval = 2 * 60 * 1000 ;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Mamager network " +
                "Operations:I'm running", Toast.LENGTH_SHORT).show();
        mContext = context;
        getCurrenctyValue();


    }



    public void getCurrenctyValue() {
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
                if(indianField != null && mContext != null) {
                    Databases db = new Databases(mContext);
                    AlarmLogger logger = new AlarmLogger();
                    logger.log_message = "USD:" + indianField.getPrice();
                    logger.dateAndTime = Calendar.getInstance().getTimeInMillis();
                    AlarmLogger.insertObject(db, logger);
                    db.close();
                }

            }

            @Override
            public void onFailure(Call<CurrencyValuePOJO> call, Throwable t) {
//                Toast.makeText(MainActivity.this,"Error:GetService" + t.getMessage(),
//                        Toast.LENGTH_LONG).show();
            }

        });
    }

    public Call<CurrencyValuePOJO> getServiceCall() {
        WebAPI serviceApi =  ServiceGenerator.createService(WebAPI.class);
        Call<CurrencyValuePOJO> call = serviceApi.getCurrencyValues();
        return call;
    }

}