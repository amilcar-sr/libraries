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

public class EventBusFragment extends Fragment {

    public final static String TAG = EventBusFragment.class.getName();

    public static EventBusFragment getInstance() {
        return new EventBusFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_bus, container, false);
    }
}
