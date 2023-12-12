package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rindex=new Random();
    String ranquote="";
    TextView quotedis;
    Button next,sharing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quotedis=findViewById(R.id.quotes);

        next=findViewById(R.id.nextbtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display();
            }
        });

        sharing=findViewById(R.id.sharebtn);

        sharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        display();
    }
    public void display(){
        int rnum=rindex.nextInt((10+1)-1)+1;

        switch (rnum){
            case 1:
                ranquote=getString(R.string.q1);
                break;
            case 2:
                ranquote=getString(R.string.q2);
                break;
            case 3:
                ranquote=getString(R.string.q3);
                break;
            case 4:
                ranquote=getString(R.string.q4);
                break;
            case 5:
                ranquote=getString(R.string.q5);
                break;
            case 6:
                ranquote=getString(R.string.q6);
                break;
            case 7:
                ranquote=getString(R.string.q7);
                break;
            case 8:
                ranquote=getString(R.string.q8);
                break;
            case 9:
                ranquote=getString(R.string.q9);
                break;
            case 10:
                ranquote=getString(R.string.q10);
                break;
        }
        quotedis.setText(ranquote);
    }

    public void share(){
        Intent sharequote=new Intent(Intent.ACTION_SEND);
        sharequote.setType("text/plain");
        sharequote.putExtra(Intent.EXTRA_TEXT,ranquote);
        startActivity(Intent.createChooser(sharequote,"Share Via"));
    }
}