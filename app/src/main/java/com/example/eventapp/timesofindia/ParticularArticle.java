package com.example.eventapp.timesofindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class ParticularArticle extends AppCompatActivity {

    TextView titleTxt, descriptionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_article);
        Intent intent = getIntent();
        String Title = intent.getStringExtra("Title");
        String Description = intent.getStringExtra("Description");

        Log.d("Title", Title);
        Log.d("Description", Description);

        titleTxt=(TextView) findViewById(R.id.titleAct);
        descriptionTxt=(TextView) findViewById(R.id.descAct);

        titleTxt.setText(Title);
        descriptionTxt.setText(Description);

    }
}
