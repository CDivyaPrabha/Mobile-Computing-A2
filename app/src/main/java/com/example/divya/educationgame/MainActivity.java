package com.example.divya.educationgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button play_button;
    private Button high_scores_button;
    private Button settings_button;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_button = (Button) findViewById(R.id.playButton);
        high_scores_button = (Button) findViewById(R.id.highScoresButton);
        settings_button = (Button) findViewById(R.id.settingsButton);
        play_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openPlayActivity();
            }
        });
        high_scores_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHighScoresActivity();
            }
        });
        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensettingsActivity();
            }
        });
    }

    public void openPlayActivity()
    {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
    public void openHighScoresActivity()
    {
        Intent intent = new Intent(this, HighScoresActivity.class);
        startActivity(intent);
    }
    public void opensettingsActivity()
    {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
