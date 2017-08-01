package com.hema.rage3nafsak;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    public static SharedPreferences preferences;
    AlarmManager mAlarmManager;
    PendingIntent pendingIntent;

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       b =(Button)findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.getText().toString().equals("تشغيل الاشعارات")){
                    b.setText("وقف الاشعارات");
                    //create new calendar instance

                    PollReceiver.scheduleAlarms(getApplicationContext());
                }



                else
                {
                    b.setText("تشغيل الاشعارات");

                }
            }
        });


        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();


        int x = preferences.getInt("kkk",0);

        if(x!=1) {



            editor.putInt("kkk", 1);
            editor.apply();

        }



    }

   public void  question (View view){

startActivity(new Intent(this,question.class));
   }

   public void statistic (View mView){
       startActivity(new Intent(this,statistic.class));



   }



}
