package fr.axa.hackathon.axalink;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import fr.axa.hackathon.axalink.database.DBHandler;

public class MainActivity extends AppCompatActivity {
    private DBHandler mDBhelper;
    private static int iterate = 0;
    private static int counter = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // copy database
        mDBhelper = new DBHandler(this);
        mDBhelper.getReadableDatabase();
        copyDatabase(this);
        //text
        final TextView question = (TextView) findViewById(R.id.question);
        question.setText(mDBhelper.getListLine().get(0).getSousTitres());
        // button yes
        Button yes = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counter!=0) {
                    iterate++;
                }else iterate--;

                counter++;

                if (iterate == 3 && counter == 4) {
                    Intent intent = new Intent(MainActivity.this, FindedActivity.class);
                    finish();
                    startActivity(intent);
                } else if(counter == 4){
                    Intent intent = new Intent(MainActivity.this,NotFoundActivity.class);
                    finish();
                    startActivity(intent);
                }else
                    question.setText(mDBhelper.getListLine().get(counter).getSousTitres());


            }
        });

        //button no
        Button no = (Button) findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter == 4){
                    Intent intent = new Intent(MainActivity.this,NotFoundActivity.class);
                    finish();
                    startActivity(intent);
                }else
                question.setText(mDBhelper.getListLine().get(counter).getSousTitres());


            }
        });
        //button unknow
        Button unknow = (Button) findViewById(R.id.unknow);
        unknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter == 4) {
                    Intent intent = new Intent(MainActivity.this, NotFoundActivity.class);
                    finish();
                    startActivity(intent);
                }else
                question.setText(mDBhelper.getListLine().get(counter).getSousTitres());

            }
        });



        // button home
        ImageView home = (ImageView) findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BeginingActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }

    private boolean copyDatabase(Context context) {
        try {

            InputStream inpuStream = context.getAssets().open(DBHandler.DBNAME);
            String outFileName = DBHandler.DBLOCATION + DBHandler.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inpuStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity", "DB copied");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

public void onStart(){
    super.onStart();
    counter = 0;
    iterate = 0;

}

}