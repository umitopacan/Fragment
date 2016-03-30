package com.ut.mis49m.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    public static String ARG_INDEX = "arg_index";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_fragment,container, false);

        // Return view
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Read arguments from bundle
        Bundle args = getArguments();
        if (args != null) {
            setText(args.getInt(ARG_INDEX));
        }
    }

    public void setText(int index){
        TextView tv = (TextView) getView().findViewById(R.id.tv_detail);

        String detail = ListItem.texts[index];
        tv.setText(detail);

    }


}
