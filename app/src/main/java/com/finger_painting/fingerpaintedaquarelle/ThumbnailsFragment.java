package com.finger_painting.fingerpaintedaquarelle;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finger_painting.fingerpaintedaquarelle.Data.ThumbnailImagesDataSource;


public class ThumbnailsFragment extends Fragment implements MyAdapter.ViewHolderClickListener{

    // callback ka main activity
    private OnThumbnailsFragmentInteractionListener mListener;

    // podrska za RecyclerView
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    public ThumbnailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_thumbnails, container, false);
        mRecyclerView = v.findViewById(R.id.my_AutoFitRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter=new MyAdapter(ThumbnailImagesDataSource.getThumbnailImages(), this);
        //mAdapter=new MyAdapter(new int[]{R.drawable.slika0_thumb,R.drawable.slika1_thumb,
               // R.drawable.slika2_thumb}, this);

        mRecyclerView.setAdapter(mAdapter);
        return v;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnThumbnailsFragmentInteractionListener) {
            mListener = (OnThumbnailsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // metoda koja se pokrece kada je pritisnut jedan od thumbnail-ova iz recycerView-a
    @Override
    public void onViewHolderClicked(int n) {

    }


     interface OnThumbnailsFragmentInteractionListener {

        void onThumbnailsFragmentInteraction(int n);
    }
}
