package com.shaadi.assignment.models;

import io.realm.RealmObject;

public class timezone extends RealmObject {
    String offset;
    String description;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
