package com.shaadi.assignment.models;

import java.io.Serializable;
import io.realm.RealmObject;

public class UserProfile extends RealmObject implements Serializable {

    String userStatus="NA";

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    name name;
    location location;
    String email;
    login login;
    dob dob;
    registered registered;
    String phone;
    String cell;
    id id;
    picture picture;

    public name getName() {
        return name;
    }

    public void setName(name name) {
        this.name = name;
    }

    public location getLocation() {
        return location;
    }

    public void setLocation(location location) {
        this.location = location;
    }

    public login getLogin() {
        return login;
    }

    public void setLogin(login login) {
        this.login = login;
    }

    public dob getDob() {
        return dob;
    }

    public void setDob(dob dob) {
        this.dob = dob;
    }

    public registered getRegistered() {
        return registered;
    }

    public void setRegistered(registered registered) {
        this.registered = registered;
    }

    public id getId() {
        return id;
    }

    public void setId(id id) {
        this.id = id;
    }

    public picture getPicture() {
        return picture;
    }

    public void setPicture(picture picture) {
        this.picture = picture;
    }

    String nat;
}
