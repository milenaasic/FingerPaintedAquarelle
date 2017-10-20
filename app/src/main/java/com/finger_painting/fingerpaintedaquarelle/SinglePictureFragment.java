package com.finger_painting.fingerpaintedaquarelle;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class SinglePictureFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PICTURENB = "picture";
    public static final int MY_PERM_WRITE_STORAGE = 100;

    private int mPictureNB;
    private View rootView;
    private OnFragmentInteractionListener mListener;
    private ImageView mImageView;



    public SinglePictureFragment() {
        // Required empty public constructor
    }


    public static SinglePictureFragment newInstance(int param1) {
        SinglePictureFragment fragment = new SinglePictureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PICTURENB, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPictureNB = getArguments().getInt("picture");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView=inflater.inflate(R.layout.fragment_single_picture, container, false);
        FloatingActionButton FAB1=rootView.findViewById(R.id.FABDownload);
        FAB1.setOnClickListener(this);
        FloatingActionButton FAB2=rootView.findViewById(R.id.FABSetWallpaper);
        FAB2.setOnClickListener(this);
        mImageView=rootView.findViewById(R.id.singlePictureFragmentImage);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.FABDownload:{
                 // ovde moram da proverim da li ima permmission i da je tražim
                if (ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_PERM_WRITE_STORAGE);
                } else {

                    downloadPictureToStorage();
                    // skini sliku sa FirebaseStorage sa Glide-om

                }


                return;
            }
            case R.id.FABSetWallpaper:{

            }
            default:return;
        }


    }

    private void downloadPictureToStorage() {


    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case MY_PERM_WRITE_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // korisnik dao permission skini sliku preko Glide-a
                    downloadPictureToStorage();

                } else {

                    Snackbar.make(rootView, "No Permission to Write To Storage", Snackbar.LENGTH_SHORT).show();
                }
                return;
            }


        }
    }





}
