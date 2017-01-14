package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MinFragment extends Fragment {


    private View view;
    public MinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_min, container, false);
        view.findViewById(R.id.btnAdd).setOnClickListener(this::addBtn);
        view.findViewById(R.id.btnReplace).setOnClickListener(this::replaceBtn);

        return view;
    }

    private void replaceBtn(View view) {
        ((MainActivity)getActivity()).runFragmentTxn(R.id.fragmentDynamic, MaxFragment.getInstance(R.drawable.ic_buses));
    }

    private void addBtn(View view) {
        ((MainActivity)getActivity()).runFragmentTxn(R.id.fragmentDynamic, MaxFragment.getInstance(R.drawable.ic_chopper));
    }
}
