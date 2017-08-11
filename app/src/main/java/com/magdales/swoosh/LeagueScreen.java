package com.magdales.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LeagueScreen extends AppCompatActivity {

    private Button btnLeague1;
    private Button btnLeague2;
    private Button btnLeague3;
    private Button btnNext;

    private TextView iAmA;
    private TextView skillDisplay;

    public static final int request_code = 2;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_screen);

        btnNext = (Button) findViewById(R.id.next_btn);
        btnLeague1 = (Button) findViewById(R.id.desired_league_button_1);
        btnLeague2 = (Button) findViewById(R.id.desired_league_button_2);
        btnLeague3 = (Button) findViewById(R.id.desired_league_button_3);

        iAmA = (TextView) findViewById(R.id.iAm);
        skillDisplay = (TextView) findViewById(R.id.skill);

        btnLeague1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.setEnabled(true);
                btnNext.setAlpha(1);
                flag = 1;
            }
        });

        btnLeague2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.setEnabled(true);
                btnNext.setAlpha(1);
                flag = 2;
            }
        });

        btnLeague3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.setEnabled(true);
                btnNext.setAlpha(1);
                flag = 3;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SkillScreen.class);
                startActivityForResult(i, request_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == request_code) {
                String message = data.getStringExtra(SkillScreen.skill_choice);
                iAmA.setVisibility(View.VISIBLE);
                skillDisplay.setVisibility(View.VISIBLE);
                skillDisplay.setText(message);
                btnNext.setVisibility(View.GONE);
                if (flag != 1) {
                    btnLeague1.setAlpha(0.50f);
                    btnLeague1.setEnabled(false);
                }
                if (flag != 2) {
                    btnLeague2.setAlpha(0.50f);
                    btnLeague2.setEnabled(false);
                }
                if (flag != 3) {
                    btnLeague3.setAlpha(0.50f);
                    btnLeague3.setEnabled(false);
                }
            }
        }
    }
}

