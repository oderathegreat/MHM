package com.example.mhm.mhm.model;

public class ModelCat {

    private String mImage;
    private String mCreator;
    private int mLikes;

    public ModelCat(String mImage, String mCreator, int mLikes) {
        this.mImage = mImage;
        this.mCreator = mCreator;
        this.mLikes = mLikes;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmCreator() {
        return mCreator;
    }

    public void setmCreator(String mCreator) {
        this.mCreator = mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }

    public void setmLikes(int mLikes) {
        this.mLikes = mLikes;
    }
}
