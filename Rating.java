package com.example.deepthigunasekara.dopost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

public class Rating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        RatingBar rate = (RatingBar)findViewById(R.id.ratingBar);
        rate.setMax(80);
        rate.setRating(20);

    }
}
