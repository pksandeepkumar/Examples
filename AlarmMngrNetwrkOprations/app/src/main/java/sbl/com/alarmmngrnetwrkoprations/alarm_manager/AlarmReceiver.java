package sbl.com.alarmmngrnetwrkoprations.alarm_manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;

import sbl.com.alarmmngrnetwrkoprations.AlarmLogger;
import sbl.com.alarmmngrnetwrkoprations.Databases;

/**
 * Created by sandeep on 11/17/2016.
 */

public class AlarmReceiver  extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();

        Databases db = new Databases(context);
        AlarmLogger logger = new AlarmLogger();
        logger.log_message = "";
        logger.dateAndTime = Calendar.getInstance().getTimeInMillis();
        AlarmLogger.insertObject(db, logger);
        db.close();
    }
}