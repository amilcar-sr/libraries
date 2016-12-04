package com.codesgood.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codesgood.libraries.R;

/**
 * Created by Amilcar on 12/4/16.
 */

public class CalligraphyFragment extends Fragment {

    public final static String TAG = CalligraphyFragment.class.getName();

    public static CalligraphyFragment getInstance() {
        return new CalligraphyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calligraphy, container, false);
        return view;
    }
}
