package com.test.data.entity;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserResponse implements DataModel{

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
    private long created;

    @SerializedName("updated")
    private long updated;

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isDegree() {
        return degree;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getCreated() {
        return created;
    }

    public long getUpdated() {
        return updated;
    }

}
