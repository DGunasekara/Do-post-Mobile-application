package com.example.deepthigunasekara.dopost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PopUpWindow extends AppCompatActivity {
    Button delivery;
    Button customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);

        delivery = (Button)findViewById(R.id.delivery);
        customer = (Button)findViewById(R.id.customer);

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopUpWindow.this,Message.class));
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopUpWindow.this,Login.class));
            }
        });

    }
}
