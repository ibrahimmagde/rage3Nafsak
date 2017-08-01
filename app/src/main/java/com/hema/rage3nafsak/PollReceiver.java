package com.hema.rage3nafsak;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class PollReceiver extends BroadcastReceiver {
    static AlarmManager mAlarmManager;

    @Override
    public void onReceive(Context ctxt, Intent i) {
        scheduleAlarms(ctxt);
    }

    static void scheduleAlarms(Context ctxt) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.HOUR_OF_DAY,1);
        mCalendar.set(Calendar.MINUTE,31);

        Intent intent=new Intent(ctxt,AlarmReceiver.class);
        PendingIntent broadcast=   PendingIntent.getBroadcast(ctxt,
                101,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        mAlarmManager=(AlarmManager) ctxt.getSystemService(ALARM_SERVICE);

        mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP,mCalendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,broadcast);
    }
}