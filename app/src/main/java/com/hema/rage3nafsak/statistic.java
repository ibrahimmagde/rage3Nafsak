package com.hema.rage3nafsak;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import static com.hema.rage3nafsak.question.azkar;
import static com.hema.rage3nafsak.question.gheba;
import static com.hema.rage3nafsak.question.prayers;
import static com.hema.rage3nafsak.question.quran;


public class statistic extends AppCompatActivity {
    private int totalPrayer =0;
    private int totalazkar =0;
    private int totalQuran =0;
    private int totalgheba=0;

    private int totalPrayerl =0;
    private int totalazkarl =0;
    private int totalQuranl =0;
    private int totalghebal=0;



    private TextView prayerET;
    private TextView quranET;
    private TextView ghebaET;
    private TextView azkarET;


    private TextView best_pray;
    private TextView best_azkar;
    private TextView best_quran;
    private TextView best_gheba;

   public static SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        best_pray = (TextView) findViewById(R.id.best_pray);
        best_azkar =(TextView) findViewById(R.id.best_azkar);
        best_quran =(TextView)findViewById(R.id.best_quran);
        best_gheba=(TextView)findViewById(R.id.best_gheba);

        prayerET = (TextView) findViewById(R.id.perc_prayer);
        azkarET =(TextView) findViewById(R.id.perc_azkar);
        quranET =(TextView)findViewById(R.id.perc_quran);
        ghebaET=(TextView)findViewById(R.id.perc_gheba);


        /*inc*/
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        totalPrayer = preferences.getInt("pray",0);
        totalQuran = preferences.getInt("quran",0);
        totalgheba = preferences.getInt("gheba",0);
        totalazkar = preferences.getInt("azkar",0);

        totalPrayer = totalPrayer+prayers;
        totalazkar = totalazkar+azkar;
        totalgheba = totalgheba +gheba;
        totalQuran = totalQuran + quran;

        prayerET.setText(String.valueOf(totalPrayer));
        azkarET.setText(String.valueOf(totalazkar));
        quranET.setText(String.valueOf(totalQuran));
        ghebaET.setText(String.valueOf(totalgheba));

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("pray", totalPrayer);
        editor.putInt("gheba", totalgheba);
        editor.putInt("quran", totalQuran);
        editor.putInt("azkar",totalazkar);

        editor.commit();


        totalPrayerl = preferences.getInt("prayl",0);
        totalQuranl = preferences.getInt("quranl",0);
        totalghebal = preferences.getInt("ghebal",0);
        totalazkarl = preferences.getInt("azkarl",0);

        best_pray.setText(String.valueOf(totalPrayerl));
        best_azkar.setText(String.valueOf(totalazkarl));
        best_quran.setText(String.valueOf(totalQuranl));
        best_gheba.setText(String.valueOf(totalghebal));

        /*timer*/

        int x = preferences.getInt("x",0);

        if(x==10) {

            editor.putInt("prayl", totalPrayer);
            editor.putInt("ghebal", totalgheba);
            editor.putInt("quranl", totalQuran);
            editor.putInt("azkarl",totalazkar);
            editor.commit();

            best_pray.setText(String.valueOf(totalPrayer));
            best_azkar.setText(String.valueOf(totalazkar));
            best_quran.setText(String.valueOf(totalQuran));
            best_gheba.setText(String.valueOf(totalgheba));

            editor.putInt("pray", 0);
            editor.putInt("gheba", 0);
            editor.putInt("quran", 0);
            editor.putInt("azkar", 0);

            editor.apply();


            totalPrayer = preferences.getInt("pray", 0);

            azkarET.setText("0");
            quranET.setText("0");
            ghebaET.setText("0");
            prayerET.setText("0");

            editor.putInt("x",11);
            editor.apply();
        }

    }

}
