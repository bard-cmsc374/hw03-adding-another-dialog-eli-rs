package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Eli on 9/28/2016.
 */
public class ListFragment extends Fragment {

    private Crime[] mCrimes;
    private String[] crimesToStrings(Crime[] crimes){
        String[] titles = new String[crimes.length];
        Crime crime;
        for (int i = 0; i < crimes.length; i++){
            crime = crimes[i];
            String title = crime.getTitle();
            titles[i] = title;
        }
        return titles;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        String[] mTitles = crimesToStrings(mCrimes);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mTitles);
        ListView mListView = (ListView) v.findViewById(R.id.list_view);
        mListView.setAdapter(listAdapter);

        return v;
    }

}
