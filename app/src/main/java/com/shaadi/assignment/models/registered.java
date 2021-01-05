package com.shaadi.assignment.models;

import io.realm.RealmObject;

public class registered  extends RealmObject {
    String date;
    String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}