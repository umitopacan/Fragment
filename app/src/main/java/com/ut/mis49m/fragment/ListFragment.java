package com.ut.mis49m.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {

    OnItemClickListener mOnItemClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Attach callback interface
        if(context instanceof MainActivity)
            mOnItemClickListener = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        // Get reference of listview object
        ListView listView = (ListView) view.findViewById(R.id.list);
        // Create adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, ListItem.items);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                mOnItemClickListener.onItemClicked(pos);
            }
        });

        // Return layout view
        return view;
    }

    // Create callback interface
    public interface OnItemClickListener{
        public void onItemClicked(int index);
    }
}
