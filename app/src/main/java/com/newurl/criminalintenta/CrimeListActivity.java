package com.newurl.criminalintenta;

import android.support.v4.app.Fragment;

/**
 * Created by a on 4/20/2016.
 */
public class CrimeListActivity extends  SingleFragmentActivity
{
    @Override
    protected Fragment createFrag() {
        return new CrimeListFrag();
    }
}
