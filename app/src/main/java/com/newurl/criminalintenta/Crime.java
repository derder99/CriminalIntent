package com.newurl.criminalintenta;

import java.util.Date;
import java.util.UUID;

/**
 * Created by a on 4/20/2016.
 */
public class Crime {
    private UUID mId; private String mTitle; private Date mDate; private boolean mSolved;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Crime(){
        mId=UUID.randomUUID(); mDate= new Date();

    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {

        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
}
