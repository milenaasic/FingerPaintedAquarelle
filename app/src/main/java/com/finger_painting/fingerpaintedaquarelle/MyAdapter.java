package com.finger_painting.fingerpaintedaquarelle;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    private int[] mDataSet;
    final private ViewHolderClickListener mClickViewHolderListener;

     MyAdapter (int[] data , ViewHolderClickListener listener){

        mDataSet=data;
        mClickViewHolderListener=listener;
    }

    // da li ova klasa mora da bude static klasa
      class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView mCardView;
        private ImageView mImageView;

         ViewHolder(LinearLayout v){
            super(v);
            CardView cardView=(CardView)v.getChildAt(0);
            mImageView=(ImageView)cardView.getChildAt(0);
            mCardView=cardView;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition=getAdapterPosition();
            mClickViewHolderListener.onViewHolderClicked(clickedPosition);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout linearLayout=(LinearLayout)LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new ViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }



     interface ViewHolderClickListener{
        void onViewHolderClicked(int n);
    }

}

