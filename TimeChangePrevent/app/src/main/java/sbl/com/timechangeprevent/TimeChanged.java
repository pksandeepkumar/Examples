package sbl.com.timechangeprevent;

/**
 * Created by sandeep on 12/21/2016.
 */

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import java.util.Calendar;

public class TimeChanged  extends BroadcastReceiver {
    public TimeChanged() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("XXXXXX","XXXXXXXXX");
        Log.e("XXXXXX","---------------Time Changed!!!");
        int isAutomaticTime;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            isAutomaticTime = android.provider.Settings.Global.getInt(context.getContentResolver(),
                    android.provider.Settings.Global.AUTO_TIME, 0);
        } else {
            isAutomaticTime = android.provider.Settings.System.getInt(context.getContentResolver(),
                    android.provider.Settings.System.AUTO_TIME, 0);

        }
//        if( isAutomaticTime == 0) {
            Calendar c = Calendar.getInstance();
            c.set(2010, 1, 1, 12, 00, 00);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            am.setTime(c.getTimeInMillis());

        if( isAutomaticTime == 0) {
            boolean autoZoneEnabled = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                Settings.Global.putInt(
                        context.getContentResolver(),
                        Settings.Global.AUTO_TIME_ZONE,
                        autoZoneEnabled ? 1 : 0);
            }
        }


//        }

        int x = isAutomaticTime;
        // Do whatever changes you need here
        // you can check the updated time using Calendar c = Calendar.getInstance();
    }
}
