package com.example.deepthigunasekara.dopost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class WelcomeMessageAndroid extends AppCompatActivity {

    RelativeLayout introMessage;
    LinearLayout appContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_message_android);

        introMessage = (RelativeLayout) findViewById(R.id.welcome_message_layout);

        final Button gotIt = (Button)findViewById(R.id.start);

        gotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeMessageAndroid.this,  PopUpWindow.class));
            }
        });

    }

    public void dismisWelcomeMessageBox(View view) {
        introMessage.setVisibility(View.INVISIBLE);
        // appContent.setVisibility(View.VISIBLE);

    }
}