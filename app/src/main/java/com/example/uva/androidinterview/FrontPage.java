package com.example.uva.androidinterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FrontPage extends AppCompatActivity implements View.OnClickListener {

    Button bsimple, btough, bseeotherapps, brateapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

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
                break;
            case R.id.brateapp:
                break;
        }
    }
}
