package com.larionov_dd.retrofit;

import com.larionov_dd.retrofit.request.PostCreateRequest;
import com.larionov_dd.retrofit.request.PostUpdateRequest;
import com.larionov_dd.retrofit.response.PostResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceHolderApi {

    @GET("/posts")
    Call<List<PostResponse>> post(@Query("userId") Integer userId);

    @POST("/posts")
    Call<PostResponse> create(@Body PostCreateRequest postCreateRequest);

    @PUT("/posts/{id}")
    Call<PostResponse> update(@Path("id") Integer id, @Body PostUpdateRequest postUpdateRequest);

    @DELETE("/posts/{id}")
    Call<Void> delete(@Path("id") Integer id);
}
