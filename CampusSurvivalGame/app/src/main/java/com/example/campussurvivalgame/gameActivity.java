package com.example.campussurvivalgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.io.Console;


public class gameActivity extends AppCompatActivity {

    int health = 100;
    int sanity = 100;
    int coolness = 0;
    int relationhip = 0;
    int h1tot = 0;
    int h2tot = 0;
    int h3tot = 0;
    int h4tot = 0;

    EditText c1;
    EditText c2;
    EditText c3;
    EditText c4;
    ProgressBar healthbar;
    ProgressBar sanitybar;
    ProgressBar coolnessbar;
    ProgressBar lovebar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        c1 = findViewById(R.id.c1_input);
        c2 = findViewById(R.id.c2_input);
        c3 = findViewById(R.id.c3_input);
        c4 = findViewById(R.id.c4_input);

        healthbar = findViewById(R.id.progressBar);
        sanitybar = findViewById(R.id.progressBar2);
        coolnessbar= findViewById(R.id.progressBar3);
        lovebar = findViewById(R.id.progressBar4);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int h1 = Integer.parseInt(c1.getText().toString());
                int h2 = Integer.parseInt(c2.getText().toString());
                int h3 = Integer.parseInt(c3.getText().toString());
                int h4 = Integer.parseInt(c4.getText().toString());
                int sanLoss = 0;
                int helLoss = 0;
                int cooLoss = 0;
                int relLoss = 0;
                int totalhoursworked = h1 + h2 + h3 + h4;
                Log.d("myTag", Integer.toString(totalhoursworked));
                if(totalhoursworked > 12) {
                    Snackbar.make(view, "You have spent more hours than possible", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
                if(totalhoursworked > 8){
                    sanLoss++;
                    helLoss++;
                }
                if(totalhoursworked <= 8){
                    sanLoss--;
                    helLoss++;
                    cooLoss--;
                    relLoss = relLoss - (coolness);
                }
                gameTick(helLoss,sanLoss,cooLoss,relLoss);
                healthbar.setProgress(health);
                sanitybar.setProgress(sanity);
                coolnessbar.setProgress(coolness);
                lovebar.setProgress(relationhip);
            }
        });
    }
    void gameTick(int h, int s, int c, int r)
    {

        if(health - h < 100){
            health = health - h;
        }
        else{
            health = 100;
        }


        if(sanity - h < 100){
            sanity = sanity - h;
        }
        else{
            sanity = 100;
        }


        if(coolness - h < 100){
            coolness = coolness - h;
        }
        else{
            coolness = 100;
        }

        if(relationhip - h < 100){
            relationhip = relationhip - h;
        }
        else{
            relationhip = 100;
        }
    }



}
