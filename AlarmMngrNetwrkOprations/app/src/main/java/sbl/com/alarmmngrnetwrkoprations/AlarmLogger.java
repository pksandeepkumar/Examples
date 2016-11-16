package sbl.com.alarmmngrnetwrkoprations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by sandeep on 03/07/16.
 */
public class AlarmLogger {

    public static final String TABLE_NAME = "TableGpsLocations";

    public static final String LOG_MESSAGE = "log_message";
    public static final String DATE_TIME = "date_time";

    public static final String CREATE_TABLE_QUERY = "CREATE TABLE  " + TABLE_NAME
            + " ( " + "_id" + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + LOG_MESSAGE + " VARCHAR , "
            + DATE_TIME + " INTEGER )";

    public int _id;
    public String log_message;
    public long dateAndTime;


    public static void insertObjects(Databases db, ArrayList<AlarmLogger> objects) {
        if( objects == null) return;
        for( AlarmLogger object : objects) {
            if( null == object ) continue;
            insertObject(db, object);
        }
    }

    public static void insertObject(Databases db, AlarmLogger object) {
        if( object == null) return;
        SQLiteDatabase sqld = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LOG_MESSAGE, object.log_message);
        cv.put(DATE_TIME, object.dateAndTime);
        long result = sqld.insert(TABLE_NAME, null,cv);
        sqld.close();
    }

    public static void updateObject(Databases db, AlarmLogger object) {
        if( object == null) return;
        SQLiteDatabase sqld = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LOG_MESSAGE, object.log_message);
        cv.put(DATE_TIME, object.dateAndTime);
        sqld.update(TABLE_NAME, cv, "_id="+object._id, null);
        sqld.close();
    }

    public static AlarmLogger getAnObjectFromCursor(Cursor c ) {
        AlarmLogger instance = null;
        if( c != null) {
            instance = new AlarmLogger();
            instance._id = c.getInt(c.getColumnIndex("_id"));
            instance.log_message = c.getString(c.getColumnIndex(LOG_MESSAGE));
            instance.dateAndTime = c.getLong(c.getColumnIndex(DATE_TIME));
        } else {

        }
        return instance;
    }

    public static boolean deleteTable(Databases db) {
        try {
            SQLiteDatabase sql = db.getWritableDatabase();
            String query = "DELETE from " + TABLE_NAME;
            sql.execSQL(query);
            sql.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean deleteTableARow(Databases db, int id) {
        try {
            SQLiteDatabase sql = db.getWritableDatabase();
            String query = "DELETE from " + TABLE_NAME + "WHERE _id = " + id;
            sql.execSQL(query);
            sql.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
