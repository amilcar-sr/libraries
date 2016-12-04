package com.codesgood.libraries.fragment;

import android.content.Context;
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

public class MainFragment extends Fragment implements View.OnClickListener {

    public final static String TAG = MainFragment.class.getName();

    private MainListener mListener;

    public interface MainListener {
        void onButtonClick(int viewId);

    }

    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (MainListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Your activity must implement MainListener in order to use this Fragment");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        view.findViewById(R.id.retrofit_button).setOnClickListener(this);
        view.findViewById(R.id.glide_button).setOnClickListener(this);
        view.findViewById(R.id.calligraphy_button).setOnClickListener(this);
        view.findViewById(R.id.event_bus_button).setOnClickListener(this);
        view.findViewById(R.id.leak_canary_button).setOnClickListener(this);
        view.findViewById(R.id.exo_player_button).setOnClickListener(this);
        view.findViewById(R.id.maps_button).setOnClickListener(this);
        view.findViewById(R.id.vision_button).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        mListener.onButtonClick(view.getId());
    }
}
