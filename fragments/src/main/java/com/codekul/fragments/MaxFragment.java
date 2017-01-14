package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaxFragment extends Fragment {

    private static final String KEY_DRAWABLE = "imgDrawable" ;
    private View view;

    public static final MaxFragment getInstance(int draw){
        MaxFragment frag = new MaxFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_DRAWABLE, draw);
        frag.setArguments(bundle);
        return frag;
    }
    public MaxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_max, container, false);

        Bundle bundle = getArguments();

        ((ImageView)view.findViewById(R.id.imageView)).setImageResource(bundle.getInt(KEY_DRAWABLE));
        return view;
    }

}
