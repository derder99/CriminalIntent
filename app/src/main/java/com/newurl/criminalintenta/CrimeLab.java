package com.newurl.criminalintenta;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by a on 4/20/2016.
 */
public class CrimeLab
{
    private static CrimeLab sCrimeLab;  // only typelevel member var, instance of self
    private List<Crime> mCrimes; // store model layer here

    public static CrimeLab get(Context ctx)
    {
        if (sCrimeLab == null){ //standard singleton code
            sCrimeLab=new CrimeLab(ctx);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context ctx){ // ctor private, accessor public
        mCrimes=new ArrayList<>();

        for (int i=9; i<20; i++){
            Crime crime= new Crime();
            crime.setTitle("Crime #: " + i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);

        }
    } // instance it

    public List<Crime> getCrimes(){
        return mCrimes; // allows outside access to model
    }

    public Crime getCrime(UUID id){ // search model by UUID

        for (Crime cri: mCrimes){
            if (cri.getId().equals(id) ) //
                return cri;             //
        }
        return null;
    }

}
