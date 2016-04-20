package com.newurl.criminalintenta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        //must be context level
        FragmentManager fm=getSupportFragmentManager();
        Fragment frag= fm.findFragmentById(R.id.fragment_container); //get frag by container

        if (frag==null){
            frag= new CrimeFragment();
            fm.beginTransaction().add(R.id.fragment_container, frag).commit();
        }

    }
}
