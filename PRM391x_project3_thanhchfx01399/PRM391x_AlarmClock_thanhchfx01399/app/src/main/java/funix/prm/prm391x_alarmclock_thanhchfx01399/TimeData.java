package funix.prm.prm391x_alarmclock_thanhchfx01399;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

// Co so du lieu SQLite luu thong tin alarm clock
public class TimeData extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "alarmManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "alarms";

    private static final String KEY_ID = "id";
    private static final String KEY_HOUR = "hour";
    private static final String KEY_MINUTE = "minute";
    private static final String KEY_STATUS = "status";


    public TimeData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_table_alarms = String.format(
                "CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s INTEGER, %s INTEGER, %s TEXT)",
                TABLE_NAME, KEY_ID, KEY_HOUR, KEY_MINUTE, KEY_STATUS
        );
        db.execSQL(create_table_alarms);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_table_alarms = String.format(
                "DROP TABLE IF EXISTS %s",
                TABLE_NAME
        );
        db.execSQL(drop_table_alarms);
        onCreate(db);
    }

    public long addAlarm(AlarmClock alarmClock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_HOUR, alarmClock.getHour());
        values.put(KEY_MINUTE, alarmClock.getMinute());
        values.put(KEY_STATUS, alarmClock.getStatus());
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public AlarmClock getAlarm(int alarmId){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                null,
                KEY_ID + " = ?",
                new String[]{String.valueOf(alarmId)},
                null,
                null,
                null
        );
        if(cursor != null) {
            cursor.moveToFirst();
        }
        AlarmClock alarm = new AlarmClock(
                cursor.getInt(0),
                cursor.getInt(1),
                cursor.getInt(2),
                cursor.getString(3)
        );

        return alarm;
    }

    public void updateAlarm(AlarmClock alarmClock) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_HOUR, alarmClock.getHour());
        values.put(KEY_MINUTE, alarmClock.getMinute());
        values.put(KEY_STATUS, alarmClock.getStatus());

        db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(alarmClock.getId())});
        db.close();

    }

    public List<AlarmClock> getAllAlarm() {
        List<AlarmClock> listAlarm = new ArrayList<AlarmClock>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                AlarmClock alarm = new AlarmClock();
                alarm.setId(cursor.getInt(0));
                alarm.setHour(cursor.getInt(1));
                alarm.setMinute(cursor.getInt(2));
                alarm.setStatus(cursor.getString(3));
                listAlarm.add(alarm);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listAlarm;
    }

    public void deleteAlarm(AlarmClock alarm) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?",
                new String[] { String.valueOf(alarm.getId()) });
        db.close();
    }
}

