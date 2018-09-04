package com.example.diego.taller1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuesserActivity extends Activity {

    int guess_count;
    Button guesser;
    EditText user_guess;
    TextView res_message;
    TextView res_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guesser);

        guess_count = 0;
        Random rand = new Random();
        Bundle extras = getIntent().getExtras();
        final int to_guess;
        to_guess = rand.nextInt(extras.getInt("MAX_VALUE", 50));

        user_guess = (EditText) findViewById(R.id.user_guess);
        res_message = (TextView) findViewById(R.id.result_message);
        res_count = (TextView) findViewById(R.id.count);
        guesser = (Button) findViewById(R.id.button);
        guesser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int guess = Integer.valueOf(user_guess.getText().toString());

                if(to_guess > guess){
                    res_message.setText(R.string.greater_message);
                    guess_count++;

                } else if (to_guess < guess ) {
                    res_message.setText(R.string.lower_message);
                    guess_count++;
                }else{
                    res_message.setText(R.string.good_guess);
                }

                res_count.setText("Numero de intentos: " + guess_count);
            }
        });
    }

}
