package fr.axa.hackathon.axalink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AtoutDroneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atout_drone);

        // button home
        ImageView home = (ImageView) findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtoutDroneActivity.this, BeginingActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
