package com.bignerdranch.android.criminalintent;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Eli on 10/24/2016.
 */
public class TimeObject implements Serializable{
    private int mHour;
    private int mMinute;
    private boolean mIsAM;
    private static final long serialVersionUID = 24L;

    public TimeObject(int hour, int minute){
        mHour = hour;
        mMinute = minute;
        mIsAM = true;
    }

    public TimeObject(int hour, int minute, boolean isAM){
        mHour = hour;
        mMinute = minute;
        mIsAM = isAM;
    }

    public int getHour() { return mHour; }
    public void setHour(int hour) { mHour = hour; }

    public int getMinute() { return mMinute; }
    public void setMinute(int minute) { mMinute = minute; }

    public boolean isAM() { return mIsAM; }
    public void setAM(boolean AM) { mIsAM = AM; }
}
