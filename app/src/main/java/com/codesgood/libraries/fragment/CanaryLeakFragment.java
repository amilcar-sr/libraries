package com.codesgood.libraries.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codesgood.libraries.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Amilcar on 12/4/16.
 */

public class CanaryLeakFragment extends Fragment {

    public final static String TAG = CanaryLeakFragment.class.getName();
    private static Activity ACTIVITY;

    public static CanaryLeakFragment getInstance() {
        return new CanaryLeakFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canary_leak, container, false);
        view.findViewById(R.id.leak_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ACTIVITY = getActivity();
            }
        });
        return view;
    }

}
