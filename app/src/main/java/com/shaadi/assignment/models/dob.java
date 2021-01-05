package com.shaadi.assignment.models;

import io.realm.RealmObject;

public class dob  extends RealmObject {
    String date;
    String age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
