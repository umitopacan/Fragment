package com.ut.mis49m.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null){
            Fragment fragment = new ListFragment();

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            // Add ListFragment
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onItemClicked(int index) {
        //  Find detail fragment by id
        DetailFragment detailFragment =  (DetailFragment)getFragmentManager().findFragmentById(R.id.fragment_detail);

        if(detailFragment!=null){
            detailFragment.setText(index);
        }else{
            Fragment fragment = new DetailFragment();

            //  Add parameter to bundle
            Bundle args = new Bundle();
            args.putInt(DetailFragment.ARG_INDEX, index);
            fragment.setArguments(args);

            //  Replace list fragment with detail fragment
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            // Replace current fragment with DetailFragment
            fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getTag());
            // Add transaction to stack
            fragmentTransaction.addToBackStack(fragment.getTag());
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            // Commit transaction
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        // Load previous fragment from the stack when user clicks the back button
        if(getFragmentManager().getBackStackEntryCount()>0) {
            getFragmentManager().popBackStack();
            return;
        }

        super.onBackPressed();
    }
}
