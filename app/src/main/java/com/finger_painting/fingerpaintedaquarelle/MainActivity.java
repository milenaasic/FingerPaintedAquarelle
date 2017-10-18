package com.finger_painting.fingerpaintedaquarelle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements ThumbnailsFragment.OnThumbnailsFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar=(Toolbar)findViewById(R.id.my_Toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public void onThumbnailsFragmentInteraction(int n) {

    }
}
