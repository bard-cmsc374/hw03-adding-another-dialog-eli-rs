package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Eli on 10/19/2016.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
