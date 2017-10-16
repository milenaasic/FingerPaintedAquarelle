package com.finger_painting.fingerpaintedaquarelle;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Milena on 14/10/2017.
 */

public class AutoFitRecyclerView extends RecyclerView {

    private GridLayoutManager manager;


    public AutoFitRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public AutoFitRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoFitRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        manager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(manager);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        int measuredWidth=getMeasuredWidth();
        int measuredHeight=getMeasuredHeight();
        Log.d ("Autofit myrec width",((Integer)measuredWidth).toString());
        Log.d ("Autofit myrec height",((Integer)measuredHeight).toString());
        int colums=columnNumber(measuredWidth,Data.Utilities.density);
        manager.setSpanCount(colums);
        Log.d ("Autofit columns",((Integer)colums).toString());
    }


    private int columnNumber(float width, float density){
        float columns=width/density/120;
        Log.d("Autofit col pre round",((Float)columns).toString());
        int colNum=Math.round(columns);
        Log.d("Autofit col posle round",((Integer)colNum).toString());
        int remain=((int)(width/density))-(colNum*120);

        Log.d("Autofit remain",((Integer)remain).toString());
        Log.d ("Autofit column number",((Float)columns).toString());
        return (int)colNum;


    }

}
