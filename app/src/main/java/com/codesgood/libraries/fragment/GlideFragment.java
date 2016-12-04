package com.codesgood.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codesgood.libraries.R;

/**
 * Created by Amilcar on 12/4/16.
 */

public class GlideFragment extends Fragment {

    public final static String TAG = GlideFragment.class.getName();

    public static GlideFragment getInstance() {
        return new GlideFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_glide, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.glide_image);

        Glide.with(this).load(getString(R.string.glide_url)).into(imageView);

        return view;
    }
}
