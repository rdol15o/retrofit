package com.larionov_dd.retrofit;

import com.larionov_dd.retrofit.request.PostCreateRequest;
import com.larionov_dd.retrofit.request.PostUpdateRequest;
import com.larionov_dd.retrofit.response.PostResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hi");

        JsonPlaceHolderApi api = JsonPlaceHolderService.getInstance().api();

        System.out.println("GET:/posts --------------");
        Response<List<PostResponse>> postResponses = api.post(null).execute();

        System.out.println(postResponses.isSuccessful());
        System.out.println(postResponses.code());
        System.out.println(postResponses.headers());
        List<PostResponse> posts = postResponses.body();
        System.out.println(posts);

        System.out.println();
        System.out.println("POST:/posts --------------");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("create");
        createRequest.setTitle("create");
        createRequest.setUserId(1);
        PostResponse postResponseCreate = api.create(createRequest).execute().body();
        System.out.println(postResponseCreate);

        System.out.println();
        System.out.println("PUT:/posts --------------");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("update");
        updateRequest.setTitle("update");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        PostResponse postResponseUpdate = api.update(1, updateRequest).execute().body();
        System.out.println(postResponseUpdate);

        System.out.println();
        System.out.println("DELETE:/posts --------------");
        Integer code = api.delete(1).execute().code();
        System.out.println(code);
    }
}
