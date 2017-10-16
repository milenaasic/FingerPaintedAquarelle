package com.finger_painting.fingerpaintedaquarelle.Data;


import com.finger_painting.fingerpaintedaquarelle.R;

/**
 * Created by Milena on 21/08/2017.
 */

public class ThumbnailImagesDataSource {

    private static int[] thumbnailImages={
            R.drawable.slika0_thumb,
            R.drawable.slika1_thumb,
            R.drawable.slika2_thumb,
            R.drawable.slika3_thumb,
            R.drawable.slika4_thumb,
            R.drawable.slika5_thumb
    };

    public static int[] getThumbnailImages() {
        return thumbnailImages;
    }

    public static int numberOfImages(){
        return thumbnailImages.length;
    }


    }




