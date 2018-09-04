package com.example.diego.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView guesser;
    ImageView list_countries;
    TextView guesser_range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        guesser = (ImageView) findViewById(R.id.game_guess);
        guesser_range = (TextView) findViewById(R.id.guesser_range);
        guesser.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), GuesserActivity.class);
                intent.putExtra("MAX_VALUE",guesser_range.getText());
                startActivity(intent);
            }
        });

        list_countries = (ImageView) findViewById(R.id.country);
        list_countries.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), ListCountriesActivity.class);
                startActivity(intent);
            }
        });
    }
}
