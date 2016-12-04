package com.codesgood.libraries.fragment;

import android.os.Bundle;
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

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    public final static String TAG = MapsFragment.class.getName();

    public static MapsFragment getInstance() {
        return new MapsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(13.6793998,-89.2392229);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in #AndroidMeeting"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
