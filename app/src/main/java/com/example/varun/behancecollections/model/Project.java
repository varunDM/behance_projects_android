package com.example.varun.behancecollections.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by varun on 12-05-2018.
 */

public class Project implements Parcelable{
    @SerializedName("id")
    private int projectId;
    @SerializedName("name")
    private String name;
    @SerializedName("covers")
    private CoverImage covers;
    @SerializedName("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String coverImageUrl;

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public Project(){

    }

    public Project(int id, String name, CoverImage coverImage, String description) {
        this.projectId = id;
        this.name = name;
        this.covers = coverImage;
        this.description = description;
    }

    public CoverImage getCovers() {
        return covers;
    }

    public void setCovers(CoverImage covers) {
        this.covers = covers;
    }

    public int getId() {
        return projectId;
    }

    public void setId(int id) {
        this.projectId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Parcel part

    public Project(Parcel in) {
        projectId = in.readInt();
        name = in.readString();
        coverImageUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(projectId);
        parcel.writeString(name);
        parcel.writeString(covers.getCover_230());
    }

    public static final Parcelable.Creator<Project> CREATOR= new Parcelable.Creator<Project>() {

        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);  //using parcelable constructor
        }

        @Override
        public Project[] newArray(int size) {
        // TODO Auto-generated method stub
            return new Project[size];
        }
    };
}
