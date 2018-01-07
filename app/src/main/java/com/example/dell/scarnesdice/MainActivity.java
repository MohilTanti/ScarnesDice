package com.example.dell.scarnesdice;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int userTotalScore;
    private int userTurnScore;
    private int computerTotalScore;
    private int computerTurnScore;

    public TextView v1, v2, v3;
    public Button b1, b2, b3;
    public ImageView iv;
    private Random random = new Random();
    private boolean rolledOne = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = (TextView) findViewById(R.id.textView2);
        v2 = (TextView) findViewById(R.id.textView3);
        v3 = (TextView) findViewById(R.id.textView5);

        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button4);

        iv = (ImageView) findViewById(R.id.imageView2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        if (!rolledOne) {
            iswinner();
            switch (v.getId()) {

                case R.id.button3:
                    b2.setEnabled(true);
                    int rollnumber = random.nextInt(6);

                    setDiceImage(iv, rollnumber);

                    if (rollnumber == 1) {
                        userTurnScore = 0;
                        Toast.makeText(this, "You rolled 1", Toast.LENGTH_SHORT).show();
                        v1.setText("User Turn Score : 0");
                        rolledOne = true;
                        iswinner();
                        ComputerTurn();
                    } else {

                        userTurnScore = userTurnScore + rollnumber;
                        v1.setText("User Turn Score : " + userTurnScore);
                        iswinner();
                    }

                    break;

                case R.id.button2:

                    userTotalScore = userTotalScore + userTurnScore;
                    v3.setText("User Score : " + userTotalScore + "");

                    rolledOne = true;
                    ComputerTurn();
                    break;

                case R.id.button4:

                    v1.setText("User Current Score");
                    v2.setText("Computer Score");
                    v3.setText("User Score");
                    b1.setEnabled(true);
                    b2.setEnabled(true);


                    userTotalScore = 0;
                    userTurnScore = 0;
                    computerTotalScore = 0;
                    computerTurnScore = 0;
                    break;
            }
        }
    }


    public void setDiceImage(ImageView mimage, int rollnumber) {
        switch (rollnumber) {
            case 1:
                mimage.setImageResource(R.drawable.d1);
                break;
            case 2:
                mimage.setImageResource(R.drawable.d2);
                break;
            case 3:
                mimage.setImageResource(R.drawable.d3);
                break;
            case 4:
                mimage.setImageResource(R.drawable.d4);
                break;
            case 5:
                mimage.setImageResource(R.drawable.d5);
                break;
            case 6:
                mimage.setImageResource(R.drawable.d6);
                break;

        }
    }

    @SuppressLint("SetTextI18n")
    public void ComputerTurn() {
        iswinner();
        int count = 3;
        if (rolledOne) {
            while (count != 0) {
                int rollnumber = random.nextInt(6);
                rollnumber=rollnumber+1;
                count--;
                userTurnScore = 0;
                b2.setEnabled(false);

                v1.setText("User Turn Score: " + userTurnScore);
                if (rollnumber == 1) {
                    computerTurnScore = 0;
                    v2.setText("Computer Score : 0");
                    computerTotalScore = computerTotalScore + computerTurnScore;
                    v2.setText("Computer Score : " + computerTotalScore + "");
                    rolledOne = false;
                    iswinner();

                } else {
                    computerTurnScore = computerTurnScore + rollnumber;
                    iswinner();
                }

            }
            computerTotalScore = computerTotalScore + computerTurnScore;
            v2.setText("Computer Score : " + computerTotalScore + "");
            rolledOne = false;
            iswinner();
        }
    }

    public void iswinner(){
        if(computerTotalScore>=100){

                b1.setEnabled(false);
                b2.setEnabled(false);
                v1.setText("YOU LOSE\n(press reset to play again)");

        }else if(userTotalScore>=100){

                b1.setEnabled(false);
                b2.setEnabled(false);
                v1.setText("YOU WON\n(press reset to play again)");

        }
    }
}
