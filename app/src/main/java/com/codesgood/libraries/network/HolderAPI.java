package com.codesgood.libraries.network;

import com.codesgood.libraries.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Amilcar on 12/4/16.
 */

public interface HolderAPI {

    @GET("posts")
    Call<List<Post>> getPosts();

}
