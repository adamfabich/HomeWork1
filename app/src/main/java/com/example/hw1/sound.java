package com.example.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class sound extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb2, rb3, rb4, rb5, rb6;
    boolean check = false;
    int soundID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        rg = findViewById(R.id.rg);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);

        rb2.setText("Dźwięk 1");
        rb3.setText("Dźwięk 2");
        rb4.setText("Dźwięk 3");
        rb5.setText("Dźwięk 4");
        rb6.setText("Dźwięk 5");
    }

    public void cancel(View view) {
        finish();
    }

    public void ok(View view) {
        if(check) {
            Intent i = new Intent();
            i.putExtra("sound", soundID);
            setResult(RESULT_OK, i);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Select sound", Toast.LENGTH_LONG).show();
        }
    }

    public void choose(View view) {
        check = ((RadioButton) view).isChecked();

        if(check) {
            switch (view.getId()) {
                case R.id.rb2:
                    soundID = R.raw.mario;
                    break;
                case R.id.rb3:
                    soundID = R.raw.ring01;
                    break;
                case R.id.rb4:
                    soundID = R.raw.ring02;
                    break;
                case R.id.rb5:
                    soundID = R.raw.ring03;
                    break;
                case R.id.rb6:
                    soundID = R.raw.ring04;
                    break;
            }
        }
    }
}
