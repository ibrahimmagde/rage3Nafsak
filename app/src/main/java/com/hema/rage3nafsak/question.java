package com.hema.rage3nafsak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class question extends AppCompatActivity {

    public static int prayers;
   public static int azkar;
    public static int quran;
    public static int gheba;

    private EditText mprayerET;
   private EditText mquranET;
    private EditText mghebaET;


   private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        mprayerET = (EditText) findViewById(R.id.prayer);


        mghebaET = (EditText) findViewById(R.id.gheba);
        mquranET = (EditText) findViewById(R.id.quran);


        rg = (RadioGroup) findViewById(R.id.radio);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.yes:
                        // do operations specific to this selection
                        azkar=1;
                        break;
                    case R.id.np:
                        // do operations specific to this selection
                        azkar =0;

                        break;
                }
            }
        });


    }


    public void done (View v){
        Log.d("before","before");

        prayers = Integer.parseInt(mprayerET.getText().toString());

        gheba = Integer.parseInt(mghebaET.getText().toString());
        quran = Integer.parseInt(mquranET.getText().toString());

        startActivity(new Intent(this,statistic.class));

    }


}
