package com.test.domain.entity;

public class User implements DomainModel {

    private String objectId;
    private String name;
    private String surname;
    private int age;
    private boolean degree;
    private String imageUrl;

    public User(){

    }

    public User(String objectId, String name, String surname, int age, boolean degree, String imageUrl) {
        this.objectId=objectId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.degree = degree;
        this.imageUrl = imageUrl;
    }

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

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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
}
