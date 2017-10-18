package com.finger_painting.fingerpaintedaquarelle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by milena.asic on 18.10.2017..
 */

public class SinglePictureActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_main);

        Toolbar myToolbar=(Toolbar)findViewById(R.id.singleToolbar);
        setSupportActionBar(myToolbar);

    }



}
