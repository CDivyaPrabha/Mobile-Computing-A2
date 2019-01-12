package com.example.divya.educationgame;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity
{
    int patterns[][] = new int[][]{
            {10, 20, 30, 40, 50, 60},
            {3, 12, 48, 192, 768, 3072},
            {5, 12, 19, 26, 33, 40},
            {82, 74, 66, 58, 50, 42},
            {5, 8, 13, 21, 34, 55},
            {2, 3, 6, 18, 108, 1944},
            {1, 3, 7, 13, 21, 31},
            {30, 29, 26, 21, 14, 5},
            {1, 5, 13, 25, 41, 61},
            {150, 143, 129, 108, 80, 45}
    };

    int options[][] = new int[][]{
            {40, 60, 70, 80}, {60, 40, 30, 50}, {70, 50, 60, 80},
            {100, 96, 192, 196}, {508, 610, 860, 768}, {2024, 3072, 1240, 4524},
            {25, 29, 26, 33}, {34, 33, 35, 36}, {40, 41, 39, 45},
            {70, 54, 58, 56}, {40, 48, 50, 52}, {40, 42, 46, 48},
            {19, 20, 21, 23}, {29, 31, 34, 37}, {49, 55, 59, 47},
            {10, 18, 12, 14}, {108, 100, 120, 125}, {1944, 1969, 2124, 1900},
            {9, 13, 15, 17}, {21, 19, 17, 23}, {27, 29, 31, 35},
            {21, 23, 19, 17}, {13, 14, 17, 11}, {9, 7, 5, 3},
            {17, 21, 19, 25}, {31, 41, 37, 47}, {51, 61, 55, 65},
            {108, 101, 121, 111}, {100, 90, 80, 70}, {60, 55, 50, 45}
    };

    TextView[] patternTexts = new TextView[]{(TextView) (findViewById(R.id.number1)),
            (TextView)(findViewById(R.id.number2)), (TextView)(findViewById(R.id.number3)),
            (TextView)(findViewById(R.id.number4)), (TextView)(findViewById(R.id.number5)),
            (TextView)(findViewById(R.id.number6))};

    Button[] optionButtons = new Button[]{(Button)(findViewById(R.id.option1)),
            (Button)(findViewById(R.id.option2)), (Button)(findViewById(R.id.option3)),
            (Button)(findViewById(R.id.option4))};

    ImageView[] characters = new ImageView[]{(ImageView)(findViewById(R.id.char1)),
            (ImageView)(findViewById(R.id.char2)), (ImageView)(findViewById(R.id.char3)),
            (ImageView)(findViewById(R.id.char4))};

    int[] images = new int[]{R.drawable.char1, R.drawable.char2, R.drawable.char3, R.drawable.char4};

    static int[] scores = new int[10];

    int i, j, k, t;
    int correctAnswer = 0;
    int character_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        int option_index=0;
        Button correct_button = (Button) findViewById(R.id.option1);

        for (i=0;i<10; i++)
        {
            for (t=0;t<3;t++)
                patternTexts[t].setText(patterns[i][t]);
            for (j=3;j<6;j++)
            {
                correctAnswer = patterns[i][j];
                characters[character_index].setImageResource(images[character_index]);
                for (k=0;k<4;k++)
                {
                    optionButtons[k].setText(options[option_index][k]);
                    if (options[option_index][k] == correctAnswer)
                        correct_button = optionButtons[k];
                    option_index++;
                }
                correct_button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        patternTexts[j].setText(correctAnswer);
                        characters[character_index++].setImageDrawable(null);
                        characters[character_index].setImageResource(images[character_index]);
                    }
                });
            }

        }
    }
}
