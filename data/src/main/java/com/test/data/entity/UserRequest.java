package com.test.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserRequest implements DataModel {

    @SerializedName("objectId")
    private String objectId;


    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("age")
    private int age;

    @SerializedName("degree")
    private boolean degree;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("created")
    private Date created;

    @SerializedName("updated")
    private Date updated;

    public void setObjectId(String id) {
        this.objectId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDegree(boolean degree) {
        this.degree = degree;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    public String getObjectId() {
        return objectId;
    }
}