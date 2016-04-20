package com.newurl.criminalintenta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by a on 4/20/2016.
 */
public class CrimeFragment extends Fragment {
    //model
    private Crime mCrime; private EditText mEditTextTitleField; private Button mDateBtn;
    private CheckBox mSolvedChkBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime= new Crime();
    }

    @Nullable // get references in oncreate view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate( R.layout.fragment_crime, container, false );//inflate view, place in activ container

        mDateBtn=(Button) v.findViewById(R.id.btnDate);
        mDateBtn.setText(mCrime.getDate().toString());
        mDateBtn.setEnabled(true);

        mSolvedChkBox=(CheckBox) v.findViewById(R.id.chkSolved);
        mSolvedChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        mEditTextTitleField=(EditText) v.findViewById(R.id.editTxtTitle);
        mEditTextTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString() );
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return v;
    }
}
