package com.example.uva.androidinterview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Uva on 7/16/2016 at 11:23 PM.
 */
public class SimpleQuestion extends AppCompatActivity implements View.OnClickListener {
    TextView tvquestion, tvanswer, tvtotallength_yy, tvpresentindex_xx;
    Button bleft, bshow, bright;
    String[] simple_questions, simple_answers;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        //Code to add Action Bar
        LinearLayout questions_ll = (LinearLayout) findViewById(R.id.questions_title_bar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);

        Button bspeak = (Button) findViewById(R.id.bspeak);
        Button bmute = (Button) findViewById(R.id.bmute);
        TextView tv_category = (TextView)findViewById(R.id.tv_questions_titlebar);
        tv_category.setText("Simple Questions");

        //  Initialization of TextView
        tvquestion = (TextView) findViewById(R.id.tvquestion);
        tvanswer = (TextView) findViewById(R.id.tvanswer);
        tvpresentindex_xx = (TextView) findViewById(R.id.tvxx);
        tvtotallength_yy = (TextView) findViewById(R.id.tvyy);

        //  Initialization of Buttons
        bleft = (Button) findViewById(R.id.bleft);
        bshow = (Button) findViewById(R.id.bshowanswer);
        bright = (Button) findViewById(R.id.bright);

        //  OnClick Listener for 3 Buttons
        bleft.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bright.setOnClickListener(this);

        //  Importing the String array from Values folder
        simple_questions = getResources().getStringArray(R.array.simple_questions);
        simple_answers = getResources().getStringArray(R.array.simple_answers);

        //  Setting values to variable and 4 TextViews
        index = 0;
        tvquestion.setText(simple_questions[index]);
        tvanswer.setText("Press \"A\" Button for the Answer");
        tvpresentindex_xx.setText(String.valueOf(index + 1));
        tvtotallength_yy.setText("/" + String.valueOf(simple_questions.length));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bleft:
                tvanswer.setText("Press \"A\" Button for the Answer");
                index--;

                if (index == -1) {
                    index = simple_questions.length - 1;
                    tvquestion.setText(simple_questions[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                } else {
                    tvquestion.setText(simple_questions[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));

                }
                break;

            case R.id.bshowanswer:
                tvanswer.setText(simple_answers[index]);
                break;

            case R.id.bright:
                tvanswer.setText("Press \"A\" Button for the Answer");
                index++;

                if (index == simple_questions.length) {
                    index = 0;
                    tvquestion.setText(simple_questions[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                } else {
                    tvquestion.setText(simple_questions[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));
                }
                break;
        }
    }
}


