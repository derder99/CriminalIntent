package com.newurl.criminalintenta;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by a on 4/20/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity
{
    protected abstract Fragment createFrag();

    @Override
    public void onCreate(Bundle savedInstanceState/*, PersistableBundle persistentState*/) {
        super.onCreate(savedInstanceState/*, persistentState*/);
        setContentView(R.layout.activity_fragment);
        //must be context level
        FragmentManager fm=getSupportFragmentManager();
        Fragment frag= fm.findFragmentById(R.id.fragment_container); //get frag by container

        if (frag==null){
            frag= createFrag(); // ////////// GENERIC, FRAGMENT IMPLEMENTS THIS
            fm.beginTransaction().add(R.id.fragment_container, frag).commit();
        }
    }
}
