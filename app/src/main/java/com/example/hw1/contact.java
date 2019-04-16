package com.example.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class contact extends AppCompatActivity {

    String[] contacts;
    ArrayAdapter<String> aa;
    Spinner sp;
    int pos = 0;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        sp= findViewById(R.id.spinner);
        contacts = getResources().getStringArray(R.array.contacts);
        aa = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, contacts);
        sp.setAdapter(aa);
    }

    public void cancel(View view) {
        finish();
    }

    public void ok(View view) {
        pos=sp.getSelectedItemPosition();
        result = contacts[pos];
        Intent i = new Intent();
        i.putExtra("contact", result);
        setResult(RESULT_OK, i);
        finish();
        }

}
