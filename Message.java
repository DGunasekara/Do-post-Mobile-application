package com.example.deepthigunasekara.dopost;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Button send = (Button)findViewById(R.id.post);
        final EditText start = (EditText)findViewById(R.id.start);
        final EditText end = (EditText)findViewById(R.id.destination);

        EditText time = (EditText)findViewById(R.id.time);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(Message.this);
                alert.setMessage("Do you want to set the route\n"+"from: "+start.getText()+" to: "+end.getText()).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Thread worker = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {

                                    String url = "http://10.40.27.163:8084/Lumos/ServletURLPattern";
                                    URL obj = new URL(url);
                                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                                    //add reuqest header
                                    con.setRequestMethod("POST");
                                    //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                                    String urlParameters = "autoMode=true&speed=1&red=1&green=1" +
                                            "" +
                                            "blue=0";

                                    // Send post request
                                    con.setDoOutput(true);
                                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                                    wr.writeBytes(urlParameters);
                                    wr.flush();
                                    wr.close();

                                    int responseCode = con.getResponseCode();
                                    System.out.println("\nSending 'POST' request to URL : " + url);
                                    System.out.println("Post parameters : " + urlParameters);
                                    System.out.println("Response Code : " + responseCode);


                                    BufferedReader in = new BufferedReader(
                                            new InputStreamReader(con.getInputStream()));
                                    String inputLine;
                                    final StringBuffer response = new StringBuffer();

                                    while ((inputLine = in.readLine()) != null) {
                                        response.append(inputLine);
                                    }
                                    in.close();

                                    //print result
                                    System.out.println(response.toString());

                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        worker.start();
                        startActivity(new Intent(Message.this,Roots.class));
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = alert.create();
                // alertDialog.setTitle("hiiii");
                alertDialog.show();

            }
        });
    }
}