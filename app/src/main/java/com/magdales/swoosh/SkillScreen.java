package com.magdales.swoosh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SkillScreen extends AppCompatActivity {

    private Button beginnerButton;
    private Button ballerButton;
    private Button finishButton;

    public static final String skill_choice = "";

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_screen);

        beginnerButton = (Button) findViewById(R.id.skill_button_1);
        ballerButton = (Button) findViewById(R.id.skill_button_2);
        finishButton = (Button) findViewById(R.id.finishButton);

        beginnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishButton.setEnabled(true);
                finishButton.setAlpha(1);
                flag = 1;
            }
        });

        ballerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishButton.setEnabled(true);
                finishButton.setAlpha(1);
                flag = 2;
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String skill = " ";
                if (flag == 1) {
                    skill = beginnerButton.getText().toString();
                } else if (flag == 2) {
                    skill = ballerButton.getText().toString();
                }

                Intent i = new Intent(view.getContext(), LeagueScreen.class);
                i.putExtra(skill_choice, skill);
                setResult(RESULT_OK, i);

                finish();
            }
        });
    }
}
