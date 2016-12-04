package com.codesgood.libraries;

import android.app.Application;

import com.codesgood.libraries.network.HolderAPI;
import com.squareup.leakcanary.LeakCanary;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amilcar on 12/4/16.
 */

public class LibrariesApplication extends Application {

    private static HolderAPI HOLDER_API;

    @Override
    public void onCreate() {
        super.onCreate();

        //LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.base_url))
                .build();

        HOLDER_API = retrofit.create(HolderAPI.class);


        //Calligraphy
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/dancingscript-regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
    }

    public static HolderAPI getAPI() {
        return HOLDER_API;
    }
}
