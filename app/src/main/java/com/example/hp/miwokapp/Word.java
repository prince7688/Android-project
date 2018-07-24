package com.example.hp.miwokapp;

/**
 * Created by HP on 5/25/2018.
 */

public class Word {
    private String mDefaultWord;
    private String mMiwokWord;
    private int mImageResourseId=0;

    public Word(String mDefaultWord, String mMiwokWord) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
    }

    public Word(String mDefaultWord, String mMiwokWord, int mImageResourseId) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.mImageResourseId = mImageResourseId;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public int getmImageResourseId() {
        return mImageResourseId;
    }
}
