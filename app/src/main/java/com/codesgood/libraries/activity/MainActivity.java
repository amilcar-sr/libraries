package com.codesgood.libraries.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codesgood.libraries.R;
import com.codesgood.libraries.event.PostClickEvent;
import com.codesgood.libraries.fragment.CalligraphyFragment;
import com.codesgood.libraries.fragment.EventBusFragment;
import com.codesgood.libraries.fragment.ExoPlayerFragment;
import com.codesgood.libraries.fragment.GlideFragment;
import com.codesgood.libraries.fragment.MainFragment;
import com.codesgood.libraries.fragment.MapsFragment;
import com.codesgood.libraries.fragment.RetrofitFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements MainFragment.MainListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, MainFragment.getInstance(), MainFragment.TAG)
                    .commit();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PostClickEvent event) {
        replaceFragment(EventBusFragment.getInstance(), EventBusFragment.TAG);
    }

    @Override
    public void onButtonClick(int viewId) {
        switch (viewId) {
            case R.id.retrofit_button:
                replaceFragment(RetrofitFragment.getInstance(), RetrofitFragment.TAG);
                break;
            case R.id.glide_button:
                replaceFragment(GlideFragment.getInstance(), GlideFragment.TAG);
                break;
            case R.id.calligraphy_button:
                replaceFragment(CalligraphyFragment.getInstance(), CalligraphyFragment.TAG);
                break;
            case R.id.event_bus_button:
                replaceFragment(RetrofitFragment.getInstance(), RetrofitFragment.TAG);
                break;
            case R.id.exo_player_button:
                replaceFragment(ExoPlayerFragment.getInstance(), ExoPlayerFragment.TAG);
                break;
            case R.id.maps_button:
                replaceFragment(MapsFragment.getInstance(), MapsFragment
                        .TAG);
                break;
            case R.id.vision_button:
                replaceFragment(RetrofitFragment.getInstance(), RetrofitFragment.TAG);
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, tag)
                .addToBackStack(null)
                .commit();
    }
}
