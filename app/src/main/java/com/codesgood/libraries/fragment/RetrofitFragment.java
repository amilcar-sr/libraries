package com.codesgood.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codesgood.libraries.LibrariesApplication;
import com.codesgood.libraries.R;
import com.codesgood.libraries.adapter.PostsAdapter;
import com.codesgood.libraries.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Amilcar on 12/4/16.
 */

public class RetrofitFragment extends Fragment {

    public final static String TAG = RetrofitFragment.class.getName();

    private RecyclerView mPostsRecycler;

    public static RetrofitFragment getInstance() {
        return new RetrofitFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retrofit, container, false);

        mPostsRecycler = (RecyclerView) view.findViewById(R.id.posts_recycler);
        mPostsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fetchPostsFromAPI();
    }

    private void fetchPost() {

    }

    private void fetchPostsFromAPI() {
        Call<List<Post>> call = LibrariesApplication.getAPI().getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    // tasks available
                    for (Post post : response.body()) {
                        Log.d(TAG, "onResponse: " + post.getTitle());
                    }

                    PostsAdapter adapter = new PostsAdapter(response.body());
                    mPostsRecycler.setAdapter(adapter);
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }
}
