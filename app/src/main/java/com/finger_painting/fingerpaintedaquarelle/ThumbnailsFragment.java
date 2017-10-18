package com.finger_painting.fingerpaintedaquarelle;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        View rootView=inflater.inflate(R.layout.fragment_thumbnails, container, false);
        mRecyclerView = rootView.findViewById(R.id.my_AutoFitRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter=new MyAdapter(ThumbnailImagesDataSource.getThumbnailImages(), this);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration decoration=new RecyclerViewDecoration(getContext());
        mRecyclerView.addItemDecoration(decoration);
        return rootView;
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
        Toast.makeText(getContext(),"prisitsnuta pozicija"+n,Toast.LENGTH_SHORT).show();
        mListener.onThumbnailsFragmentInteraction(n);
    }


     interface OnThumbnailsFragmentInteractionListener {

        void onThumbnailsFragmentInteraction(int n);
    }
}
