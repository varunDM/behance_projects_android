package com.example.varun.behancecollections.network;

import com.example.varun.behancecollections.model.ProjectDetailResponse;
import com.example.varun.behancecollections.model.ProjectsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by varun on 12-05-2018.
 */

public interface ApiInterface {
    @GET("projects")
    Call<ProjectsResponse> getProjects(@Query("api_key") String apiKey);

    @GET("projects/{id}")
    Call<ProjectDetailResponse> getProjectDetail(@Path("id") int id, @Query("api_key") String apiKey);
}
