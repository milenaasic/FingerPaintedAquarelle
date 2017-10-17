package com.finger_painting.fingerpaintedaquarelle;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.finger_painting.fingerpaintedaquarelle.Data.Utilities;


public class AutoFitRecyclerView extends RecyclerView {

    private GridLayoutManager manager;
    private static final String DEBUG_TAG="AutoFitRecyclerView";


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
        Log.d (DEBUG_TAG,((Integer)measuredWidth).toString());
        Log.d (DEBUG_TAG,((Integer)measuredHeight).toString());
        float myDensity=getContext().getResources().getDisplayMetrics().density;
        Utilities.setThisScreenResolution(myDensity);
        //int colums=columnNumber(measuredWidth,myDensity);
        float columns=measuredWidth/myDensity/120;
        int colNum=Math.round(columns);
        manager.setSpanCount(colNum);
        Log.d (DEBUG_TAG,((Integer)colNum).toString());
    }

    /* izračunava broj kolona
    private int columnNumber(float width, float density){
        float columns=width/density/120;
        Log.d(DEBUG_TAG,((Float)columns).toString());
        int colNum=Math.round(columns);
        return (int)colNum;
    }*/

}
