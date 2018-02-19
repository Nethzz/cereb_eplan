package com.campusiq.cereb_eplan;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by campusiq on 16/02/18.
 */

public class User   {
    String name,email,pass,designation,username,phone;
    int id;



    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(int id, String name, String designation, String email, String phone, String username, String pass)
    {
        this.id=id;
        this.name = name;
        this.designation=designation;
        this.email = email;
        this.phone=phone;
        this.username=username;

        this.pass = pass;


    }



}
