package com.example.hw1;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    ImageView iv;
    String[] pic;
    String name;
    int rand = 0;
    MediaPlayer mp;
    Uri uri;
    int soundID=R.raw.mario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);

        tv.setText("Wybierz kontakt");

        pic = getResources().getStringArray(R.array.pictures);
        uri = Uri.parse(pic[0]);
        iv.setImageResource(getApplicationContext().getResources().getIdentifier
                ("" + uri, null, getApplicationContext().getPackageName()));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(mp != null){
                    mp.stop();
                    mp = null;
                }else{
                    mp = MediaPlayer.create(getApplicationContext(), soundID);
                    mp.start();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void contact(View view) {
        Intent intent = new Intent(getApplicationContext(), contact.class);
        startActivityForResult(intent, 1);
    }

    public void sound(View view) {
        Intent intent = new Intent(getApplicationContext(), sound.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                name = data.getStringExtra("contact");
                tv.setText(name);
                choosePic();
            }
            else if(requestCode == 2){
                soundID = data.getIntExtra("sound", 0);
            }
        }else{
            Toast.makeText(getApplicationContext(), "Powrót", Toast.LENGTH_LONG).show();
        }
    }

    public void choosePic(){
        Random r = new Random();
        rand = r.nextInt(5);

        uri = Uri.parse(pic[rand]);
        iv.setImageResource(getApplicationContext().getResources().getIdentifier
                ("" + uri, null, getApplicationContext().getPackageName()));

    }


}