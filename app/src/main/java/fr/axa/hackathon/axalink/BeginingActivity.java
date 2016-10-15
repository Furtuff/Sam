package fr.axa.hackathon.axalink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BeginingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begining);
        //button pro

        ImageButton pro = (ImageButton)findViewById(R.id.pro);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginingActivity.this,MainActivity.class);

                startActivity(intent);

            }
        });
        // button publique
        ImageButton publique = (ImageButton)findViewById(R.id.publique);
        publique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginingActivity.this,MainActivity.class);

                startActivity(intent);

            }
        });

        // hamburger button

        ImageView hamburger = (ImageView)findViewById(R.id.hamburger);
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginingActivity.this,HamburgerActivity.class);
                startActivity(intent);
            }
    });



}
}
