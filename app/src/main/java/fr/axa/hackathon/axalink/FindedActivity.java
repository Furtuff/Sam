package fr.axa.hackathon.axalink;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class FindedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finded);
        // button home


        ImageView atoutDrone = (ImageView)findViewById(R.id.atoutDrone);
        atoutDrone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(FindedActivity.this,AtoutDroneActivity.class);
                finish();
                startActivity(intent);
            }
        });
        ImageView home = (ImageView) findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindedActivity.this, BeginingActivity.class);
                finish();
                startActivity(intent);
            }
        });
        // button reclamation
        ImageView reclamation = (ImageView)findViewById(R.id.reclamation);
        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindedActivity.this,ReclamationActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }




}
