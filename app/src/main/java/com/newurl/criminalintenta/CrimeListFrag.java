package com.newurl.criminalintenta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class CrimeListFrag extends Fragment
{
    private RecyclerView mCrimeRecyclerView; private CrimeAdapter mAdapter;

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes; // adapter model
        public CrimeAdapter(List<Crime> crimes ){ // ctor
            mCrimes = crimes; //
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater= LayoutInflater.from(getActivity() );// tie inflater to
                //crimeListActivity
            View v= layoutInflater.inflate( R.layout.list_item_crime, parent, false);

             // make textview, inflate from std profile, place in viewgroup pointer
            return new CrimeHolder(v);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) { //bind data to the viewHolder

            Crime crime= mCrimes.get( position);//grab model for this # view
            //holder.mTitleTxtVw.setText( crime.getTitle() );//
            holder.bindCrimeMdlToUI(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

    }

////////////VIEWHOLDER. holder is programmatic container
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView mTitleTxtVw; private TextView mDateTxtView; private CheckBox mSolvedChkBx;
        private Crime mCrime;

        public CrimeHolder(View itemView){
            super(itemView); //ViewHolder; // get refs to all 3 elements,Title, date, solved
            itemView.setOnClickListener(this); // setListener on Holder

            mTitleTxtVw= (TextView) itemView.findViewById(R.id.li_title_txtVw);
            mDateTxtView=(TextView) itemView.findViewById(R.id.li_date_txtVw);
            mSolvedChkBx=(CheckBox) itemView.findViewById(R.id.li_solved_chkBox);
             //non-generic implement.  Here, view must be text, TextView
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), mCrime.getTitle() + "clicked", Toast.LENGTH_SHORT).show();
        }

        public void bindCrimeMdlToUI(Crime crime)
        {
            mCrime=crime; // get mdl ref, set UI with mdl state
            mTitleTxtVw.setText(mCrime.getTitle() ); mSolvedChkBx.setChecked(mCrime.isSolved() );
            mDateTxtView.setText(mCrime.getDate().toString() );
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView= (RecyclerView) v.findViewById(R.id.crime_recycler_view);

        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity() )
                                            );
        updateUI();

        return v;
    }

    private void updateUI()
    {
        CrimeLab crimeLab = CrimeLab.get(getActivity() );//get ref to model
        List<Crime> crimes = crimeLab.getCrimes(); //

        mAdapter = new CrimeAdapter(crimes); // adapter links model to ViewHolders
        mCrimeRecyclerView.setAdapter(mAdapter); // set reculcerview adapter
    }

}
