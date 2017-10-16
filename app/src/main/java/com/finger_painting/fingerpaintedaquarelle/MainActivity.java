package com.finger_painting.fingerpaintedaquarelle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.finger_painting.fingerpaintedaquarelle.Data.Utilities;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar=(Toolbar)findViewById(R.id.my_Toolbar);
        setSupportActionBar(myToolbar);

        // izracunaj screenresolution i setuj ga u Utilities klasi
        float myDensity=getResources().getDisplayMetrics().density;
        Utilities.setThisScreenResolution(myDensity);

    }
}
