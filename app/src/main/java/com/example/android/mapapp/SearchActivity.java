package com.example.android.mapapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by gydoy on 11/1/2018.
 */

public class SearchActivity extends AppCompatActivity {

    public void sendLocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        EditText editText =(EditText) findViewById(R.id.location_query);
        String message = editText.getText().toString();
        String dummyAddress = "1600 Amphitheatre Parkway, Mountain View, CA";
        intent.putExtra("location", message);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);
        final Button button = (Button) findViewById(R.id.enter_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendLocation(v);
            }
        });
    }

}
