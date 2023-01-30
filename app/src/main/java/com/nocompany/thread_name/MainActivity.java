package com.nocompany.thread_name;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
 Button b;
 TextView tw;
 int t,random_number,pocet_spravnych,pocet_spatnych;
 int[] pole;
 List<Button> tlacitka;
 boolean gaming_time;
 Random rand = new Random();
 int d;
 ProgressBar prg;
 protected void funkce()
{
    t=0;
    random_number = rand.nextInt(10);
    pocet_spatnych = 0;
    pocet_spravnych = 0;
    prg.setProgress(0);

    for (int qt = 0;qt<=tlacitka.size()-1;qt++)
    {
        final int rrr = qt;
            pole[rrr]=(rand.nextInt(10));
            tlacitka.get(rrr).setText(Integer.toString(pole[rrr]));
            tlacitka.get(rrr).setBackgroundColor(Color.WHITE);
            tlacitka.get(rrr).setEnabled(true);
        if (pole[rrr]==random_number) {
            pocet_spravnych++;
        }
    }

    if (pocet_spravnych==0) {
        funkce();
    }
    prg.setMax(pocet_spravnych);
    b.setText(Integer.toString(random_number));
    //new AlertDialog.Builder(this).setTitle(Integer.toString(pocet_spravnych)).setMessage(Integer.toString(tlacitka.size())+"\n"+Integer.toString(pole.length)).show();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        gaming_time = true;
        pole = new int[36];
        b = findViewById(R.id.button0);
        prg = findViewById(R.id.progressBar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            prg.setMin(0);
        }
        tw = findViewById(R.id.textView);
        tlacitka = new ArrayList<Button>();
        tlacitka.clear();
        tlacitka.add((Button)findViewById(R.id.button1));
        tlacitka.add((Button)findViewById(R.id.button2));
        tlacitka.add((Button)findViewById(R.id.button3));
        tlacitka.add((Button)findViewById(R.id.button4));
        tlacitka.add((Button)findViewById(R.id.button5));
        tlacitka.add((Button)findViewById(R.id.button6));
        tlacitka.add((Button)findViewById(R.id.button7));
        tlacitka.add((Button)findViewById(R.id.button8));
        tlacitka.add((Button)findViewById(R.id.button9));
        tlacitka.add((Button)findViewById(R.id.button10));
        tlacitka.add((Button)findViewById(R.id.button11));
        tlacitka.add((Button)findViewById(R.id.button12));
        tlacitka.add((Button)findViewById(R.id.button13));
        tlacitka.add((Button)findViewById(R.id.button14));
        tlacitka.add((Button)findViewById(R.id.button15));
        tlacitka.add((Button)findViewById(R.id.button16));
        tlacitka.add((Button)findViewById(R.id.button17));
        tlacitka.add((Button)findViewById(R.id.button18));
        tlacitka.add((Button)findViewById(R.id.button19));
        tlacitka.add((Button)findViewById(R.id.button20));
        tlacitka.add((Button)findViewById(R.id.button21));
        tlacitka.add((Button)findViewById(R.id.button22));
        tlacitka.add((Button)findViewById(R.id.button23));
        tlacitka.add((Button)findViewById(R.id.button24));
        tlacitka.add((Button)findViewById(R.id.button25));
        tlacitka.add((Button)findViewById(R.id.button26));
        tlacitka.add((Button)findViewById(R.id.button27));
        tlacitka.add((Button)findViewById(R.id.button28));
        tlacitka.add((Button)findViewById(R.id.button29));
        tlacitka.add((Button)findViewById(R.id.button30));
        tlacitka.add((Button)findViewById(R.id.button31));
        tlacitka.add((Button)findViewById(R.id.button32));
        tlacitka.add((Button)findViewById(R.id.button33));
        tlacitka.add((Button)findViewById(R.id.button34));
        tlacitka.add((Button)findViewById(R.id.button35));
        tlacitka.add((Button)findViewById(R.id.button36));
        funkce();

        new AlertDialog.Builder(this).setTitle("Hra").setMessage("Začít?").setPositiveButton("Ano", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gaming_time=true;
                b.setText(Integer.toString(random_number));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (gaming_time==true)
                        {
                            t+=1;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tw.setText("Uplynulý čas: "+Integer.toString(t));
                                    if (pocet_spravnych==0) {
                                        //pocet_spravnych = -1;

                                                String v;
                                                v = "";
                                                String l = Integer.toString(t);
                                                if (l == "1") {
                                                    v = "sekundu";
                                                }
                                                if (l == "2" || l == "3" || l == "4") {
                                                    v = "sekundy";
                                                } else {
                                                    v = "sekund";
                                                }
                                                String pp = String.format("Hra skoncila. Máte: %s chyb\nDokončeno v čase: %s %s", Integer.toString(pocet_spatnych), Integer.toString(t), v);
                                                Toast toast = Toast.makeText(getApplicationContext(), pp, Toast.LENGTH_SHORT);
                                                toast.show();

                                                funkce();

                                        try {
                                            Thread.sleep(10);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }).start();
            }
        }).setNegativeButton("Ne", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);
            }
        }).show();


        for (d = 0;d<=tlacitka.size()-1;d++)
        {
            final int current = d;
                tlacitka.get(d).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int y = Integer.parseInt(tlacitka.get(current).getText().toString());
                        if (y == random_number) {
                            tlacitka.get(current).setBackgroundColor(Color.GREEN);
                            pocet_spravnych--;
                            prg.setProgress(prg.getProgress()+1);
                        }
                        if (y != random_number) {
                            tlacitka.get(current).setBackgroundColor(Color.RED);
                            pocet_spatnych++;
                        }
                        tlacitka.get(current).setEnabled(false);
                        //Toast.makeText(getApplicationContext(),Integer.toString(pocet_spravnych),Toast.LENGTH_SHORT).show();
                    }
                });
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
