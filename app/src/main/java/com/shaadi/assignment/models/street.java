package com.shaadi.assignment.models;

import io.realm.RealmObject;

public class street  extends RealmObject {
    int number;
    String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

