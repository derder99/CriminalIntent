package com.newurl.criminalintenta;

import android.content.Context;

/**
 * Created by a on 4/20/2016.
 */
public class CrimeLab
{
    private static CrimeLab sCrimeLab;  // only typelevel member var, instance of self

    public static CrimeLab get(Context ctx)
    {
        if (sCrimeLab == null){
            sCrimeLab=new CrimeLab(ctx);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context ctx){ // ctor private, accessor public

    }
}
