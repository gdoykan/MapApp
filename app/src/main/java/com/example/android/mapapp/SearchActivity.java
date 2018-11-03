package com.example.android.mapapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;

/**
 * Created by gydoy on 11/1/2018.
 */

public class SearchActivity extends AppCompatActivity {

    public void sendLocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        EditText editText =(EditText) findViewById(R.id.location_query);
        StringBuilder message = editText.getText().toString();
        boolean oncampus=true;


		Geocoder geocoder = new Geocoder(this);
        try {
            addressList = geocoder.getFromLocationName(message,1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Address res = addressList.get(0);
        if (res.getLatitude()>30.292 && res.getLatitude()<30.281){
        	if (res.getLongitude()> (-97.728) && res.getLongitude()< (-97.742){
        		oncampus=false;
        	}
        }




        if (oncampus){message.append(" you're on campus");}
        
        String dummyAddress = "1600 Amphitheatre Parkway, Mountain View, CA";
        intent.putExtra("location", message.toString);
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
