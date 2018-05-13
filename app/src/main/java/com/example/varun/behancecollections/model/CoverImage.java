package com.example.varun.behancecollections.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by varun on 12-05-2018.
 */

public class CoverImage {
    @SerializedName("115")
    private String cover_115;
    @SerializedName("202")
    private String cover_202;
    @SerializedName("230")
    private String cover_230;
    @SerializedName("404")
    private String cover_404;
    @SerializedName("original")
    private String cover_original;

    public CoverImage(String cover_115, String cover_202, String cover_230, String cover_404, String cover_original) {
        this.cover_115 = cover_115;
        this.cover_202 = cover_202;
        this.cover_230 = cover_230;
        this.cover_404 = cover_404;
        this.cover_original = cover_original;
    }

    public String getCover_115() {
        return cover_115;
    }

    public String getCover_202() {
        return cover_202;
    }

    public String getCover_230() {
        return cover_230;
    }

    public String getCover_404() {
        return cover_404;
    }

    public String getCover_original() {
        return cover_original;
    }
}
