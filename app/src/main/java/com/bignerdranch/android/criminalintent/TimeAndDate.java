package com.bignerdranch.android.criminalintent;

import java.io.InterruptedIOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Eli on 10/24/2016.
 */
public class TimeAndDate implements Serializable {

    private int mMinute;
    private int mHour;
    private int mDay;
    private int mMonth;
    private int mYear;
    private static final long serialVersionUID = 365L;

    public TimeAndDate(int minute, int hour, int day, int month, int year){
        mMinute = minute;
        mHour = hour;
        mDay = day;
        mMonth = month;
        mYear = year;
    }

    public TimeAndDate(){
        Calendar calendar = Calendar.getInstance();
        mMinute = calendar.get(Calendar.MINUTE);
        mHour = calendar.get(Calendar.HOUR);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mMonth = calendar.get(Calendar.MONTH);
        mYear = calendar.get(Calendar.YEAR);
    }

    public String toString() {
        Boolean am = true;
        if (mHour >= 1 && mHour <= 11) {am = true;}
        else if(mHour == 12) {am = false;}
        else if(mHour >= 13 && mHour <= 23) {am = false;}
        else if(mHour == 24) {am = true;}

        String minute = Integer.toString(mMinute);
        if (mMinute < 10) {minute = "0" + minute;}
        String hour;
        if (mHour > 12) {hour = Integer.toString(mHour - 12);}
        else{hour = Integer.toString(mHour);}
        if (hour == "0") { hour = "12"; }
        String day = Integer.toString(mDay);
        if (mDay < 10) {day = "0" + day;}
        String month = Integer.toString(mMonth);
        if (mMonth < 10) {month = "0" + month;}
        String year = Integer.toString(mYear);
        String phase;
        if (am) {phase = "am";}
        else {phase = "pm";}
        String fullText = month + "/" + day + "/" + year + "   " + hour + ":" + minute + phase;
        return fullText;


    }

    public Date getDate() {
        Date date = new Date(mYear, mMonth, mDay);
        return date;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setMinute(int minute) {
        mMinute = minute;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int hour) {
        mHour = hour;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int day) {
        mDay = day;
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        mMonth = month;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }
}
