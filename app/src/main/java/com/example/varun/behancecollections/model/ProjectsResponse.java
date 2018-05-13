package com.example.varun.behancecollections.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by varun on 12-05-2018.
 */

public class ProjectsResponse {
    @SerializedName("projects")
    private List<Project> results;

    public List<Project> getResults() {
        return results;
    }
}
