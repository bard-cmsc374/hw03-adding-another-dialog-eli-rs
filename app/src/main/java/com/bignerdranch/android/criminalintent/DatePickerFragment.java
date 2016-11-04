package com.bignerdranch.android.criminalintent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Eli on 10/20/2016.
 */
public class DatePickerFragment extends DialogFragment {

    private static final String ARG_DATE = "date";
    private static final String ARG_TIME = "time";
    private static final String ARG_DATETIME = "dateTime";

    private DatePicker mDatePicker;
    private TimePicker mTimePicker;

    public static final String EXTRA_DATE = "com.bignerdranch.android.criminalintent.date";
    public static final String EXTRA_DATETIME = "com.bignerdranch.android.criminalintent.dateTime";

    public static DatePickerFragment newInstance(Date date, TimeObject time) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        args.putSerializable(ARG_TIME, time);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public static DatePickerFragment newInstance(TimeAndDate timeAndDate){
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATETIME, timeAndDate);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        TimeAndDate timeAndDate = (TimeAndDate) getArguments().getSerializable(ARG_DATETIME);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_date_picker);
        mDatePicker.init(timeAndDate.getYear(), timeAndDate.getMonth(), timeAndDate.getDay(), null);

        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_date_time_picker);
        if (Build.VERSION.SDK_INT >= 23) {
            mTimePicker.setHour(timeAndDate.getHour());
            mTimePicker.setMinute(timeAndDate.getMinute());
        }
        else {
            mTimePicker.setCurrentHour(timeAndDate.getHour());
            mTimePicker.setCurrentMinute(timeAndDate.getMinute());
        }

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                int year = mDatePicker.getYear();
                                int month = mDatePicker.getMonth();
                                int day = mDatePicker.getDayOfMonth();
                                int hour = mTimePicker.getCurrentHour();
                                int minute = mTimePicker.getCurrentMinute();
                                if (Build.VERSION.SDK_INT >= 23) {
                                    hour = mTimePicker.getHour();
                                    minute = mTimePicker.getMinute();
                                }
                                TimeAndDate timeAndDate = new TimeAndDate(minute, hour, day, month, year);
                                sendResult(Activity.RESULT_OK, timeAndDate);
                            }
                        })
                .create();
    }
    private void sendResult(int resultCode, TimeAndDate timeAndDate){
        if (getTargetFragment() == null){
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATETIME, timeAndDate);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

}
