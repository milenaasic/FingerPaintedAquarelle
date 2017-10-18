package com.finger_painting.fingerpaintedaquarelle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

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
        Toast.makeText(this," pozicija iz Main"+n,Toast.LENGTH_SHORT).show();

        if(n==0){
            Intent intent=new Intent();
            // ako je odabrana 0 pošalji u Single picture informaciju koji je broj slike odabran
           // ali ne treba mi permission

        }
    }
}
