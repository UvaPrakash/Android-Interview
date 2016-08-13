package com.example.uva.androidinterview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FrontPage extends AppCompatActivity implements View.OnClickListener {

    Button bsimple, btough, bseeotherapps, brateapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        //Code to add Action Bar
        LinearLayout frontpage_ll = (LinearLayout) findViewById(R.id.frontpage_title_bar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.frontpage_title_bar);


        bsimple = (Button) findViewById(R.id.bsq);
        btough = (Button) findViewById(R.id.btq);
        bseeotherapps = (Button) findViewById(R.id.bseeotherapps);
        brateapp = (Button) findViewById(R.id.brateapp);

        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bseeotherapps.setOnClickListener(this);
        brateapp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bsq:
                Intent i = new Intent(FrontPage.this, SimpleQuestion.class);
                startActivity(i);
                break;
            case R.id.btq:
                Intent j = new Intent(FrontPage.this, ToughQuestion.class);
                startActivity(j);
                break;
            case R.id.bseeotherapps:
                try {
                    Uri uri = Uri.parse("market://search?q=PublisherName");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    Uri uri = Uri.parse("http://play.google.com/store/search?q=PublisherName");
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                }
                break;
            case R.id.brateapp:
                try {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                }

                break;
        }
    }
}
