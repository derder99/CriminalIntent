package com.newurl.criminalintenta;

import android.app.IntentService;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.content.*;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    public static final String EXTRA_CRIME_ID="com.newurl.crimInt.crime_id";

    public static Intent newIntent(Context pckgCtx, UUID crimeId)
    {   // Serializable = byteStream convertable back to object
        Intent i= new Intent(pckgCtx, CrimeActivity.class);
        i.putExtra(EXTRA_CRIME_ID, crimeId);
        return i;
    }

    @Override
    protected Fragment createFrag() {
        return new CrimeFragment();
    }
}
