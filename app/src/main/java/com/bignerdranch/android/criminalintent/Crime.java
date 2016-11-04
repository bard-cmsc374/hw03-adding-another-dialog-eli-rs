package com.bignerdranch.android.criminalintent;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Eli on 9/26/2016.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private TimeObject mTime;
    private TimeAndDate mTimeAndDate;
    private boolean mSolved;

    public Crime(){
        //generate unique identifier
        mId = UUID.randomUUID();
        mTimeAndDate = new TimeAndDate();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }

    public TimeAndDate getTimeAndDate() { return mTimeAndDate; }
    public void setTimeAndDate(TimeAndDate timeAndDate) { mTimeAndDate = timeAndDate; }
    public Date getDate() { return mTimeAndDate.getDate(); }

    public boolean isSolved() { return mSolved; }
    public void setSolved(boolean solved) {
        mSolved = solved;
    }

}
