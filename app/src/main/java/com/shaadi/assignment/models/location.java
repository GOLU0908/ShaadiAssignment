package com.shaadi.assignment.models;

import io.realm.RealmObject;

public class location extends RealmObject {
    street street;
    String city;
    String state;
    String postcode;

    public street getStreet() {
        return street;
    }

    public void setStreet(street street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    coordinates coordinates;


    timezone timezone;

    public coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(timezone timezone) {
        this.timezone = timezone;
    }


    @Override
    public String toString() {
        return street + " " + postcode + " " + city + " " + state;
    }
}

