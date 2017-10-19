package com.finger_painting.fingerpaintedaquarelle;

import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class SinglePictureActivity extends AppCompatActivity implements SinglePictureFragment.OnFragmentInteractionListener {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_singlepicture);

        Toolbar myToolbar=(Toolbar)findViewById(R.id.singleToolbar);
        setSupportActionBar(myToolbar);


        int intExtra = getIntent().getIntExtra(MainActivity.PICTURENB_TO_DOWNLOAD,0);

        SinglePictureFragment fragment=SinglePictureFragment.newInstance(intExtra);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
