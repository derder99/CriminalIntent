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
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by a on 4/20/2016.
 */
public class CrimeFragment extends Fragment {
    //model
    private Crime mCrime; private EditText mEditTextTitleField; private Button mDateBtn;
    private CheckBox mSolvedChkBox; private TextView mTxtTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // mCrime= new Crime();
        UUID crimeId= (UUID) getActivity().getIntent().getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);
        // getIntent starting activ, convert from serialized to T,
        mCrime= CrimeLab.get(getActivity() ).getCrime(crimeId);
    }

    @Nullable // get references in oncreate view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate( R.layout.fragment_crime, container, false );//inflate view, place in activ container

        mTxtTitle=(TextView) v.findViewById(R.id.txtTitle);
        mTxtTitle.setText(mCrime.getTitle() );

        mDateBtn=(Button) v.findViewById(R.id.btnDate);
        mDateBtn.setText(mCrime.getDate().toString());
        mDateBtn.setEnabled(true);

        mSolvedChkBox=(CheckBox) v.findViewById(R.id.chkSolved);
        mSolvedChkBox.setChecked(mCrime.isSolved() );
        mSolvedChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        mEditTextTitleField=(EditText) v.findViewById(R.id.editTxtTitle);
        //set state from extra

        mEditTextTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString() ); mTxtTitle.setText(s.toString());
            }

            @Override //maybe move above to here?
            public void afterTextChanged(Editable s) { }
        });

        return v;
    }
}
